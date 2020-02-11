package sk.zrebec.learn.animals;

import sk.zrebec.learn.Animal;

public class Cat extends Animal {

	/*
	@Override
	public String describeAnimal() {
		return this.getClass().getName() + " make " + getSound() + " and usually weight is " + getWeight();
	}
	*/

	@Override
	public void setAnimal() {
		super.isMale(false);
		super.setSound("Meow");
		super.setWeight(5);
	}
	
}
