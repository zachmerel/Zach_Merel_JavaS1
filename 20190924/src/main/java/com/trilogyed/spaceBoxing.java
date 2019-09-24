package com.trilogyed;

import java.util.Scanner;

public class spaceBoxing {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double venusGravity = .78;
        double venusWeight = 0;
        double marsGravity = .39;
        double marWeight = 0;
        double jupiterGravity = 2.65;
        double jupiterWeight = 0;
        double saturnGravity = 1.17;
        double saturnWeight = 0;
        double uranusGravity= 1.05;
        double uranusWeight = 0;
        double neptuneGravity = 1.23;
        double neptuneWeight = 0;
        System.out.println("Please enter your current earth weight:");
        double earthWeight = Double.parseDouble(scanner.nextLine());

        System.out.println("I have information for the following planets:\n" +
                "   1. Venus   2. Mars    3. Jupiter\n" +
                "   4. Saturn  5. Uranus  6. Neptune");

        System.out.println("Which planet are you visiting?");
        int planetNumber = Integer.parseInt(scanner.nextLine());

        switch (planetNumber){
            case 1:
                venusWeight = venusGravity*earthWeight;
                System.out.println("Your weight would be " + venusWeight + " pounds on that planet.");
                break;
            case 2:
                marWeight = marsGravity*earthWeight;
                System.out.println("Your weight would be " + marWeight + " pounds on that planet.");
                break;
            case 3:
                jupiterWeight = jupiterGravity*earthWeight;
                System.out.println("Your weight would be " + jupiterWeight + " pounds on that planet.");
                break;
            case 4:
                saturnWeight = saturnGravity*earthWeight;
                System.out.println("Your weight would be " + saturnWeight + " pounds on that planet.");
                break;
            case 5:
                uranusWeight = uranusGravity*earthWeight;
                System.out.println("Your weight would be " + uranusWeight + " pounds on that planet.");
                break;
            case 6:
                neptuneWeight = neptuneGravity*earthWeight;
                System.out.println("Your weight would be " + neptuneWeight + " pounds on that planet.");
                break;
        }
    }


}
