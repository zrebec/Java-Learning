package com.electroshop;

class Phone {

    enum Props {BRAND, MODEL, PROCESSOR_TYPE, RAM, ROM}

    enum Brands {APPLE, SAMSUNG}
    enum ProcessorTypes {BIONIC, EXYNOS, QUALCOMM}

    final private Brands brand;
    final private String model;
    private ProcessorTypes processorType;
    private int ramSize;
    private int romSize;
    private static int phoneCounter = 0;

    public Phone(Brands brand, String model) {
        phoneCounter++;
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

    public static int getPhoneCounter() {
        return phoneCounter;
    }

    static void savePhoneInformation (Phone phone) {
        System.out.printf("Brand: %s\n", phone.brand);
        System.out.printf("Model: %s\n", phone.model);
        System.out.printf("Specifications: %d GB RAM, %d GB internal storage\n",
                phone.ramSize, phone.romSize);
    }

    static void savePhoneInformation (Phone phone, Props property) {
        switch (property) {
            case BRAND: System.out.println("Brand: " + phone.brand); break;
            case MODEL: System.out.println("Model: " + phone.model); break;
            case PROCESSOR_TYPE: System.out.println("Model: "
                    + phone.processorType); break;
            case RAM: System.out.println("RAM: " + phone.ramSize); break;
            case ROM: System.out.println("Storage: " + phone.romSize); break;
        }
    }
}