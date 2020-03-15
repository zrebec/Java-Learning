package sk.zrebec.learn;

public abstract class Animal {

	public enum Sex {MALE, FEMALE}

	private double weight;
	private Sex sex;
	private String sound;
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double d) {
		this.weight = d;
	}
	
	public Sex getSex() {
		return this.sex;
	}
	
	public void setSex(Sex sex) {
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
		return this.getClass().getSimpleName() + ( getSound().equals("") ? " doesn't make sound"  : " make " + getSound() ) + " and " + ( (getSex() == Sex.MALE ) ? "his" : "her" ) + " usually weight is " + getWeight() + "kg.";
	}

	public abstract void setAnimal();

}
