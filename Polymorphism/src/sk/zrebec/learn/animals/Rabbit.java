package sk.zrebec.learn.animals;

import sk.zrebec.learn.Animal;

public class Rabbit extends Animal {

	/*
	@Override
	public String describeAnimal() {
		return this.getClass().getName() + " make " + getSound() + " and usually weight is " + getWeight();
	}
	*/

	@Override
	public void setAnimal() {
		super.isMale(true);
		super.setSound(null);
		super.setWeight(4.17);
		
	}

}
