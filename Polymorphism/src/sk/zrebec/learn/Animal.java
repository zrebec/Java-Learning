package sk.zrebec.learn;

public abstract class Animal {
	
	private double weight;
	private boolean sex;
	private String sound;
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double d) {
		this.weight = d;
	}
	
	public boolean isMale() {
		return sex;
	}
	
	public void isMale(boolean sex) {
		this.sex = sex;
	}
	
	public String getSound() {
		if (sound != null && !sound.isEmpty()) return sound;
		else return "";
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}

	public String describeAnimal() {
		return this.getClass().getSimpleName() + ( getSound().equals("") ? " doesn't make sound"  : " make " + getSound() ) + " and " + ( isMale() ? "his" : "her" ) + " usually weight is " + getWeight() + "kg.";
	}

	public abstract void setAnimal();

}
