package EnterTitan;

public class Player extends Hero implements Gatcha,Comparable<Player>{
	private long totalGold;
	private int gold ; 
	private double criticalRate ; 
	private double criticalDamage ; 
	
	
	
	public Player(String name, int stage, long damage, long totalGold, int gold, double criticalRate,
			double criticalDamage) {
		super(name, stage, damage);
		this.totalGold = totalGold;
		this.gold = gold;
		this.criticalRate = criticalRate;
		this.criticalDamage = criticalDamage;
	}
	public Player() {
		super();
	}
	public long getTotalGold() {
		return totalGold;
	}
	public void setTotalGold(long totalGold) {
		this.totalGold += totalGold;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public double getCriticalRate() {
		return criticalRate;
	}
	public void setCriticalRate(double criticalRate) {
		this.criticalRate = criticalRate;
	}
	public double getCriticalDamage() {
		return criticalDamage;
	}
	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}

	@Override
	public long attack() {
        if(isDrop(criticalRate)) {
            return (long) (this.getDamage() * (1 + this.getCriticalDamage()));
        }
        return (long) this.getDamage();
    }
	
	@Override
	public boolean isDrop(double criticalRate) {
		if(Math.random() < criticalRate) return true;
		else return false;
	}
	@Override
	public int compareTo(Player o) {
		if(this.getStage()<o.getStage()) {
			return 1;
		}else if(this.getStage()==o.getStage()){
			return -1;	
		}else {
			return -1;}
		
	}

}
