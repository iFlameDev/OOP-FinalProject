package EnterTitan;

public class Shop {
	private int shopAttack, shopCD, shopCR, shopPSA, shopPD;

	public int getShopAttack() {
		return shopAttack;
	}

	public int getShopCD() {
		return shopCD;
	}

	public int getShopCR() {
		return shopCR;
	}

	public int getShopPSA() {
		return shopPSA;
	}

	public int getShopPD() {
		return shopPD;
	}

	public void setShopAttack(int shopAttack) {
		this.shopAttack = shopAttack;
	}

	public void setShopCD(int shopCD) {
		this.shopCD = shopCD;
	}

	public void setShopCR(int shopCR) {
		this.shopCR = shopCR;
	}

	public void setShopPSA(int shopPSA) {
		this.shopPSA = shopPSA;
	}

	public void setShopPD(int shopPD) {
		this.shopPD = shopPD;
	}

	public Shop(int shopAttack, int shopCD, int shopCR, int shopPSA, int shopPD) {
		super();
		this.shopAttack = shopAttack;
		this.shopCD = shopCD;
		this.shopCR = shopCR;
		this.shopPSA = shopPSA;
		this.shopPD = shopPD;
	}
	
}
