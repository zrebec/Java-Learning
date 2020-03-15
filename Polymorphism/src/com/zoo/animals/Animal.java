package com.zoo.animals;

class Animal {

    // Set enums
    enum Species {BEAR, FOX, WOLF, RABBIT, DEER}
    enum Sex {MALE, FEMALE}
    enum Fluctuations {NONE, ONLY_TERRITORY, ACROSS_TERRITORIES, ONLY_CONTINENT, ACROSS_CONTINENTS}
    enum Biotopes {UNDERGROUND, HUMID, FOREST, RIVER, SEA, OCEAN, AIR}

    // Specie of animal
    private final Species specie;

    // Sex of animal
    private final Sex sex;

    // Average length of life in years
    private final int avgLifeLength;

    // Average weight in kilograms
    private final int avgWeight;

    // Average height in meters and centimeters
    private final float avgHeight;

    // Fluctuation
    private final Fluctuations fluctuation;

    // Natural biotope
    private final Biotopes biotope;

    Animal(Species specie, Sex sex, int avgLifeLength, int avgWeight, float avgHeight, Fluctuations fluctuation, Biotopes biotope) {
        this.specie = specie;
        this.sex = sex;
        this.avgLifeLength = avgLifeLength;
        this.avgWeight = avgWeight;
        this.avgHeight = avgHeight;
        this.fluctuation = fluctuation;
        this.biotope = biotope;
    }

    public Species getSpecie() {
        return specie;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAvgLifeLength() {
        return avgLifeLength;
    }

    public int getAvgWeight() {
        return avgWeight;
    }

    public float getAvgHeight() {
        return avgHeight;
    }

    public Fluctuations getFluctuation() {
        return fluctuation;
    }

    public Biotopes getBiotope() {
        return biotope;
    }

}