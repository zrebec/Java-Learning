package com.electroshop;

public class Electroshop {

    public static void main(String[] args) {
        Phone[] phones = new Phone[5];

        phones[0] = new Phone(Phone.Brands.APPLE, "8");
        phones[1] = new Phone(Phone.Brands.APPLE, "XS Max");
        phones[2] = new Phone(Phone.Brands.SAMSUNG, "A50");
        phones[3] = new Phone(Phone.Brands.SAMSUNG, "S20");
        phones[4] = new Phone(Phone.Brands.SAMSUNG, "S10e");

        // iPhone 8 (Bionic, 2GB RAM, 64GB internal storage)
        phones[0].setProcessorType(Phone.ProcessorTypes.BIONIC);
        phones[0].setRamSize(2);
        phones[0].setRomSize(64);

        // iPhone XS Max (Bionic, 2GB RAM, 64GB internal storage)
        phones[1].setProcessorType(Phone.ProcessorTypes.BIONIC);
        phones[1].setRamSize(4);
        phones[1].setRomSize(256);

        // Samsung A50 (Exynos)
        phones[2].setProcessorType(Phone.ProcessorTypes.EXYNOS);
        phones[2].setRamSize(6);
        phones[2].setRomSize(128);

        // Samsung S20 (Exynos)
        phones[3].setProcessorType(Phone.ProcessorTypes.EXYNOS);
        phones[3].setRamSize(16);
        phones[3].setRomSize(512);

        // Samsung S10e (Exynos)
        phones[4].setProcessorType(Phone.ProcessorTypes.QUALCOMM);
        phones[4].setRamSize(64);
        phones[4].setRomSize(128);

        System.out.println("-------------------------------------------");
        for (var phone : phones) {
            System.out.println("Phone: " + phone.getBrand() + ' ' + phone.getModel());
            System.out.printf("Specifications: Processor %s, %d RAM, %d Internal storage\n",
                    phone.getProcessorType(), phone.getRamSize(), phone.getRomSize());
            System.out.println("-------------------------------------------");
        }

        System.out.println("Total cell phones for sell: " + Phone.getPhoneCounter());


    }

}
