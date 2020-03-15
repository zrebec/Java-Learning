package sk.zrebec.learn;

import sk.zrebec.learn.animals.Cat;
import sk.zrebec.learn.animals.Dog;
import sk.zrebec.learn.animals.Rabbit;

public class Animals {

	public static void main(String[] args) {

		try {
			Animal[] animals = new Animal[3];
			animals[0] = new Dog();
			animals[1] = new Cat();
			animals[2] = new Rabbit();

			for (Animal animal : animals) {
				animal.setAnimal();
				System.out.println(animal.describeAnimal());
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Not enough or too much animals. Class: " +
					e.getClass().toString() + ". Message: " + e.getMessage());
		} finally {
			System.out.println("Done");
		}
	}
}