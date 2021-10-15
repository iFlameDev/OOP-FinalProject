package EnterTitan;


public class Partner extends Hero implements Runnable{

	private double attackCd ; //2000
	private boolean charge;
	private int sumAttack;
			
	
	
	public Partner(String name, int stage, long damage, double attackCd, boolean charge, int sumAttack) {
		super(name, stage, damage);
		this.attackCd = attackCd;
		this.charge = charge;
		this.sumAttack = sumAttack;
	}
	public void startThread() {
		Thread th = new Thread(this);
		th.start();
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public int getSumAttack() {
		return sumAttack;
	}

	public void resetSumAttack() {
		this.sumAttack = 0;
	}

	public int getAttackCd() {
		return (int)(this.attackCd*1000.0);
	}
	
	public void setAttackCd(double attackCD) {
		this.attackCd = attackCD;
	}
	
	@Override
	public long attack() {
		return this.getDamage() ;
	}
	@Override
	public void run() {
		while(charge) {
			System.out.printf("Partner is Attacking!!! -%d point\n", attack());	
			sumAttack+=attack();
			try {
				Thread.sleep(this.getAttackCd());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
