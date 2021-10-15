package EnterTitan;

public class Boss extends Enemy{

	private int regen ; 
	private int bonusDrop ;

	public Boss(int stage, int x,int i) {
		setHealthPoint(stage, x);
		setBounty(stage,i);
		setRegen(stage);
		bonusDrop = bonusDrop();
	}
  public Boss() {
	  
	  
  }

	
	public int getRegen() {
		return regen;
	}

	private void setRegen(int stage) {
		this.regen = stage*5;
	}

	private int bonusDrop() {
		// random antara 5 field
		int x = (int)(Math.random()*5) ;  
		return x; 
	}
	
	private void setHealthPoint(int stage, int x) {
		healthPoint = (int)((stage*stage + x*stage + x)*1.5);
	}

	public void setBounty(int stage,int i) {
//		bounty = stage*10 + (int)(stage*0.1) + (int)(Math.random()*100);
		bounty = stage*i*11 + (int)(Math.random()*i*10);
	}
	
	public int getBonusDrop() {
		return bonusDrop;
	}
	

}
