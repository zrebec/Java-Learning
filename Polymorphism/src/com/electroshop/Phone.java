package com.electroshop;

class Phone {

    enum Brands {APPLE, SAMSUNG}
    enum ProcessorTypes {BIONIC, EXYNOS, QUALCOMM}

    private Brands brand;
    private String model;
    private ProcessorTypes processorType;
    private int ramSize;
    private int romSize;

    public Phone(Brands brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void setProcessorType(ProcessorTypes processorType) {
        this.processorType = processorType;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setRomSize(int romSize) {
        this.romSize = romSize;
    }

    public Brands getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public ProcessorTypes getProcessorType() {
        return processorType;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getRomSize() {
        return romSize;
    }
}