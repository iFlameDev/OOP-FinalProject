package EnterTitan;

abstract public class Hero implements Attack{

	protected String name ; 
	protected int stage;
	protected long damage ; 

	public Hero(){
		
	}
	
	public Hero(String name, int stage, long damage) {
		super();
		this.name = name;
		this.stage = stage;
		this.damage = damage;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}


	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDamage() {
		return damage;
	}

	public void setDamage(long damage) {
		this.damage = damage;
	}


	
}
