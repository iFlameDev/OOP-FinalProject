package EnterTitan;

public class Monster extends Enemy implements Gatcha{

	private boolean bountyBonus = false;

	public Monster(int stage, int x,int i) {
		setBounty(stage,i);
		setHealthPoint(stage, x);
	}
	public Monster() {
		
	}
	
	public boolean isBountyBonus() {
		return bountyBonus;
	}

	public void setBountyBonus(boolean bountyBonus) {
		this.bountyBonus = bountyBonus;
	}

	
	public void setBounty(int stage,int i) {
//	        bounty = stage*10 + (int)(stage*0.1) + (int)(Math.random()*100);
			bounty = stage*i*11 + (int)(Math.random()*i*10);
	        if(isDrop(0.1)) {
	            this.bounty = bounty*10;
	            this.bountyBonus = true;
	        }else {
	        	this.bountyBonus = false ; 
	        }
	  }
	 public void setHealthPoint(int stage, int x) {
	        healthPoint = stage*stage + x*stage + x;
	 }

	@Override
	public boolean isDrop(double x) {
		if(Math.random() <= x) return true;
		else return false;
	}

}
