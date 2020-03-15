package com.zoo.animals;

import java.util.ArrayList;

public class MyZoo {

    public static void main(String[] args) {

        ArrayList<Animal> myAnimals = new ArrayList<>();

        myAnimals.add(new Animal(Animal.Species.RABBIT, Animal.Sex.MALE, 5, 4, 0.25f, Animal.Fluctuations.NONE, Animal.Biotopes.FOREST));
        myAnimals.add(new Animal(Animal.Species.WOLF, Animal.Sex.FEMALE, 15, 6, 0.5f, Animal.Fluctuations.ONLY_TERRITORY, Animal.Biotopes.FOREST));

        for(Animal animal : myAnimals) {
            System.out.println("Specie: " + animal.getSpecie());
            System.out.println("Sex: " + animal.getSex());
            System.out.println("Average life length: " + animal.getAvgLifeLength());
            System.out.println("Average weight: " + animal.getAvgWeight());
            System.out.println("Average height: " + animal.getAvgHeight());
            System.out.println("Fluctuation: " + animal.getFluctuation());
            System.out.println("Biotope: " + animal.getBiotope());
            System.out.println("--------------------------------------------");
        }

    }

}
