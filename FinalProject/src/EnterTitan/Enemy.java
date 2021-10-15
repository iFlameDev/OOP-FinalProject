package EnterTitan;

abstract public class Enemy {

	protected long healthPoint ; 
	protected int bounty ;

	public long getHealthPoint() {
		return healthPoint;
	}
	public void setHealthPoint(long healthPoint) {
		this.healthPoint = healthPoint;
	}
	public int getBounty() {
		return bounty;
	}
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

}
