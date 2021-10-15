package EnterTitan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	// admin
	// player
	// leaderboard

	// base attack, critDamage, critRate, partnerAttackSpeed, partnerDamage ;

	// partner
	// base attspeed, attackDamage

	// monster
	// base hp, base bounty

	// boss
	// base hp, base bounty

	Scanner scan = new Scanner(System.in);
	File file = new File("HeroSave.txt");
	Scanner sc;
	FileWriter fileWriter;
	Player Heroes;
	ArrayList<Player> leaderBoard = new ArrayList<Player>();
	Shop shop;
	Partner partner;
	Player player;
	Hero admin;
	String[] data;
	Thread th;

	int stage;
	int baseAttack = 1;
	int healthPoint = 1;
	double criticalDamage = 0.5;
	double criticalRate = 0.1;
	double partnerAttackSpeed = 3.0;
	int partnerDamage = 1;
	int bounty = 1;

	// int admBaseAttack = 1 ;
	// int admHealthPoint = 1;
	// double admCriticalDamage = 0.5 ;
	// double admCriticalRate = 0.1 ;
	// double admPartnerAttackSpeed = 3.0 ;
	// int admPartnerDamage = 1 ;

	void cls() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

	void writeFile() {
		String data;
		for (Player temp : leaderBoard) {

			data = temp.getName() + "#" + temp.getStage();

			try {
				if (file.createNewFile()) {
					fileWriter = new FileWriter(file, true);
					fileWriter.write(data + '\n');
					fileWriter.close();

				} else {
					fileWriter = new FileWriter(file, false);
					fileWriter.write(data + '\n');
					fileWriter.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void writeExit() {
		String data;
		try {
			fileWriter = new FileWriter(file, false);
		} catch (Exception e) {
		}

		for (Player temp : leaderBoard) {

			data = temp.getName() + "#" + temp.getStage();

			try {
				if (file.createNewFile()) {
					fileWriter = new FileWriter(file, true);
					fileWriter.write(data + '\n');
					fileWriter.close();

				} else {
					fileWriter = new FileWriter(file, true);
					fileWriter.write(data + '\n');
					fileWriter.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void readFile() {
		Player h;
		leaderBoard.removeAll(leaderBoard);
		if (file.exists()) {

			try {
				sc = new Scanner(file);

				while (sc.hasNextLine()) {

					data = sc.nextLine().split("#");
					h = new Player();
					h.setName(data[0]);
					h.setStage(Integer.parseInt(data[1]));
					leaderBoard.add(h);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("File not exists, cant read file !");
		}

	}

	void adminLogin() {
		int menu;
		do {
			System.out.println("1. Edit Player Setup");
			System.out.println("2. Edit Partner Setup");
			System.out.println("3. Edit Monster Setup");
			System.out.println("4. Reset LeaderBoard");
			System.out.println("5. Exit");
			System.out.println(">> ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					System.out.println("EDIT Player");
					playerUpgrade();
					break;
				case 2:
					System.out.println("EDIT Partner");
					partnerUpgrade();
					break;
				case 3:
					System.out.println("EDIT Monster");
					monsterUpgrade();
					break;
				case 4:
					System.out.println("Reset LeaderBoard");
					try {
						fileWriter = new FileWriter(file, false);
						fileWriter.close();
						readFile();
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
			}
		} while (menu != 5);
	}

	void result() {
		System.out.printf("Last Stage : \n");
		System.out.printf("Total Gold Earned : \n");
		System.out.printf("Total Damage : \n");
		System.out.println("Last Stat\n");
	}

	void shop() {

		int menu = 0;
		do {
			cls();

			System.out.printf("Shop           ||Your Gold : %d\n", player.getGold());
			System.out.println("====================================");
			System.out.println("1. Upgrade base attack             | " + shop.getShopAttack());
			System.out.println("2. Upgrade critical damage         | " + shop.getShopCD());
			System.out.println("3. Upgrade critical rate           | " + shop.getShopCR());
			System.out.println("4. Upgrade partner speed attack    | " + shop.getShopPSA());
			System.out.println("5. Upgrade partner damage          | " + shop.getShopPD());
			System.out.println("6. Exit shop");
			System.out.print("Choose >> ");

			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			scan.nextLine();

			switch (menu) {
				case 1:
					if (player.getGold() >= shop.getShopAttack()) {
						System.out.println("BASE ATTACK");
						player.setGold(player.getGold() - shop.getShopAttack());
						shop.setShopAttack((int) (shop.getShopAttack() * 1.5));
						upgrade(menu - 1);
						System.out.println("Purchase Successful");
						scan.nextLine();
					} else {
						System.out.println("Not Enough Money");
						scan.nextLine();
					}

					break;
				case 2:
					if (player.getGold() >= shop.getShopCD()) {
						System.out.println("CRITICAL DAMAGE");
						player.setGold(player.getGold() - shop.getShopCD());
						shop.setShopCD((int) (shop.getShopCD() * 1.5));
						upgrade(menu - 1);
						System.out.println("Purchase Successful");
						scan.nextLine();
					} else {
						System.out.println("Not Enough Money");
						scan.nextLine();

					}

					break;
				case 3:
					if (player.getGold() >= shop.getShopCR()) {
						System.out.println("CRITICAL RATE");
						player.setGold(player.getGold() - shop.getShopCR());
						shop.setShopCR((int) (shop.getShopCR() * 1.5));
						upgrade(menu - 1);
						System.out.println("Purchase Successful");
						scan.nextLine();
					} else {
						System.out.println("Not Enough Money");
						scan.nextLine();
					}

					break;
				case 4:
					if (player.getGold() >= shop.getShopPSA()) {
						System.out.println("PARTNER SPEED ATACK");
						player.setGold(player.getGold() - shop.getShopPSA());
						shop.setShopPSA((int) (shop.getShopPSA() * 1.5));
						upgrade(menu - 1);
						System.out.println("Purchase Successful");
						scan.nextLine();
					} else {
						System.out.println("Not Enough Money");
						scan.nextLine();
					}

					break;
				case 5:
					if (player.getGold() >= shop.getShopPD()) {
						System.out.println("PARTNER DAMAGE");
						player.setGold(player.getGold() - shop.getShopPD());
						shop.setShopPD((int) (shop.getShopPD() * 1.5));
						upgrade(menu - 1);
						System.out.println("Purchase Successful");
						scan.nextLine();
					} else {
						System.out.println("Not Enough Money");
						scan.nextLine();
					}

					break;
			}

		} while (menu != 6);
	}
	//

	void playerLogin() {
		shop = new Shop(50, 50, 50, 50, 50);
		Monster m = new Monster();
		Boss b = new Boss();
		stage = 1;
		String choose;
		long hp = 0;
		int flag = 0;
		int gold;
		// kalo namanya enter threadnya ke run 2 kali
		partner.setCharge(true);
		try {
			partner.startThread();
		} catch (Exception e) {
			e.printStackTrace();
		}
		do {
			if (stage % 5 != 0) {
				m = new Monster(stage, healthPoint, bounty);
				hp = m.getHealthPoint();
			} else {
				b = new Boss(stage, healthPoint, bounty);
				hp = b.getHealthPoint();
			}

			do {

				cls();
				System.out.printf("Stage : %d\t\t Monster HP : %d\n", stage, hp);
				System.out.println("========================================");
				System.out.println("Input \"Shop\" to open Shop Menu");
				System.out.println("Press enter to attack");
				System.out.println("Input \"Exit\" to exit game");
				System.out.println("--------------------------------");
				System.out.println("Stat Hero : ");
				System.out.printf("Player Attack	 : %d\n", player.attack());
				System.out.printf("Partner Attack	 : %d / %.1f s\n", partner.attack(),
						(double) (partner.getAttackCd()) / 1000);

				choose = scan.nextLine();

				if (choose.equalsIgnoreCase("Shop")) {
					partner.setCharge(false);
					shop();
					partner.setCharge(true);
					try {
						partner.startThread();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (choose.isEmpty()) {
					hp -= player.attack();
				} else if (choose.equalsIgnoreCase("Exit")) {
					partner.setCharge(false);
					player.setStage(stage);
					leaderBoard.add(player);
					Collections.sort(leaderBoard);
					if (leaderBoard.size() > 10) {
						leaderBoard.remove(10);
					}
					writeFile();
					writeExit();
					break;

				}

				hp -= partner.getSumAttack();
				partner.resetSumAttack();
				if (stage % 5 == 0 && hp < (int) (b.getHealthPoint() * 0.2) && flag == 0) {
					hp += b.getRegen();
					flag = 1;
				}
			} while (hp > 0);
			flag = 0;
			// ini terminate dps partner
			// partner.setCharge(false);

			// bounty
			if (stage % 5 != 0) { // monster biasa
				if (m.isBountyBonus()) {
					System.out.println("You get Bounty bonus !!!");
				}

				gold = m.getBounty();
				System.out.printf("You get %d golds\n", gold);
				player.setGold(player.getGold() + gold);
			} else { // boss
				System.out.println("You defeat the boss");
				gold = m.getBounty();
				System.out.printf("You get %d golds\n", gold);
				player.setGold(player.getGold() + gold);
				System.out.print("You get free upgrade \n");
				String[] string = { "Base Damage", "Critical Damage", "Critical Rate", "Partner Damage",
						"Partner DPS" };
				for (int i = 0; i < 5; i++) {
					if (i == b.getBonusDrop()) {
						System.out.println(string[i] + " from special drop");
						upgrade(i - 1);
					}
				}

			}
			stage++;

		} while (!choose.equalsIgnoreCase("Exit"));

		// result() ;
		// input ke file <leader board>
	}

	// void upgrade(int i) {
	// if(i == 0)baseAttack+=1;
	// else if(i == 1)criticalDamage+=0.1;
	// else if(i == 2)criticalRate+=0.05;
	// else if(i == 3)partnerAttackSpeed-=0.1;
	// else if(i == 4)partnerDamage+=1;
	// }
	void upgrade(int i) {
		if (i == 0)
			player.setDamage(player.getDamage() + 1);
		else if (i == 1)
			player.setCriticalDamage(player.getCriticalDamage() + 0.1);
		else if (i == 2)
			player.setCriticalRate(player.getCriticalRate() + 0.05);
		else if (i == 3)
			partner.setAttackCd((double) (partner.getAttackCd()) / 1000.0 - 0.1);
		else if (i == 4)
			partner.setDamage(partner.getDamage() + 1);
	}

	void playerUpgrade() {
		int menu;

		do {
			System.out.println("1. BaseAttack");
			System.out.println("2. Critical Damage");
			System.out.println("3. Critical Rate");
			System.out.println("4. Exit");
			System.out.println(">> ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					System.out.println("Input BaseAttack");
					baseAttack = scan.nextInt();
					break;
				case 2:
					System.out.println("Input CriticalDamage");
					criticalDamage = scan.nextDouble();

					break;
				case 3:
					System.out.println("Input CriticalRate");
					criticalRate = scan.nextDouble();

					break;
			}
		} while (menu != 4);
	}

	void monsterUpgrade() {
		int menu;
		do {
			System.out.println("1. HealtPointBase");
			System.out.println("2. Bounty");
			System.out.println("3. Exit");
			System.out.println(">> ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					System.out.println("Input HealthPointBase: ");
					healthPoint = scan.nextInt();
					break;
				case 2:
					System.out.println("Input BountyRate: ");
					bounty = scan.nextInt();
					break;
			}
		} while (menu != 3);
	}

	void partnerUpgrade() {
		int menu;
		do {
			System.out.println("1. PartnerAttack");
			System.out.println("2. PartnerAttackSpeed");
			System.out.println("3. Exit");
			System.out.println(">> ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					System.out.print("Input PartnerAttack: ");
					partnerDamage = scan.nextInt();

					break;
				case 2:
					System.out.print("Input PartnerAttackSpeed: ");
					partnerAttackSpeed = scan.nextDouble();
					break;
			}
		} while (menu != 3);
	}

	// isi username aja gausa pw
	void statusReset() {
		baseAttack = 1;
		healthPoint = 1;
		criticalDamage = 0.5;
		criticalRate = 0.1;
		partnerAttackSpeed = 3.0;
		partnerDamage = 1;
	}

	void login() {
		String name;

		String password;
		int count = 0;
		int flag = 0;
		// Player hero = null;

		// do {
		System.out.println("Enter your name : ");
		name = scan.nextLine();
		player = new Player(name, 1, baseAttack, 0, 0, criticalRate, criticalDamage);
		partner = new Partner(player.name, stage, partnerDamage, partnerAttackSpeed, false, 0);
		//
		// if(name.equals("admin")) {
		// flag = 1 ;
		// }
		//
		// for(Player h : heroes) {
		// if(h.name.equals(name)) {
		// flag = 1 ;
		// hero = h ;
		// }
		//
		// }
		//
		// if(flag == 0) {
		// count++ ;
		// }
		// }while(count != 3 && flag != 1) ;
		//
		// if(count == 3 || flag == 0) {
		// return ;
		// }
		//
		// flag = 0 ;
		//
		// do {
		// System.out.println("Enter your password : ");
		// password = scan.nextLine() ;
		//
		// if(password.equals("admin123")) {
		// flag = 1 ;
		// }
		//
		// // for(Hero h : heroes) {
		// // if(h.password.equals(password))
		// // flag = 1 ;
		// // }
		//
		// if(hero.password.equals(password))
		// flag = 1 ;
		//
		// if(flag == 0) {
		// count++ ;
		// }
		// }while(count != 3 && flag != 1) ;

		if (name.equalsIgnoreCase("admin")) {
			do {
				System.out.println("Enter password for Admin : ");
				password = scan.nextLine();

				if (password.equalsIgnoreCase("admin123")) {
					flag = 1;
				}
				if (flag == 0) {
					count++;
				}
			} while (count != 3 && flag != 1);
			adminLogin();
		} else {

			playerLogin();
		}

	}

	// void register() {
	// String name ;
	// String password ;
	// do {
	// System.out.print("Input your name[5-15 characters] : ");
	// name = scan.nextLine() ;
	// }while(name.length() < 5 || name.length() > 15) ;
	//
	// do {
	// System.out.print("Input your password[5-10 characters] : ");
	// password = scan.nextLine() ;
	// }while(password.length() < 5 || password.length() > 10) ;
	//
	//
	// //heroes.add(new Player(name, password,0, baseAttack,0, 0, criticalRate,
	// criticalDamage));
	//
	//
	// System.out.println("Player has been added");
	// }

	void leaderboard() {
		System.out.println("CURRENT LEADERBOARD");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
		for (Player temp : leaderBoard) {
			System.out.printf("Name: %s\n", temp.getName());
			System.out.printf("Stage: %d\n", temp.getStage());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
		}
		scan.nextLine();
	}

	public Main() {
		int menu;
		readFile();
		do {
			System.out.println("ENTER TITAN");
			System.out.println("============");
			System.out.println("1. Play");
			System.out.println("2. Leaderboard");
			System.out.println("3. Exit");
			System.out.print(">> ");

			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					login();
					break;
				case 2:
					leaderboard();
					break;
				case 3:
					writeExit();
					break;
			}
		} while (menu != 3);

	}

	public static void main(String[] args) {
		new Main();
	}

}
