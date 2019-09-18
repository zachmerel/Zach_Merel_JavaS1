package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the width of the driveway");
        int drivewayWidth = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the length of the driveway");
        int drivewayLength = Integer.parseInt(scanner.nextLine());

        int drivewayArea = drivewayWidth * drivewayLength;
        System.out.println("The area of the driveway is " + drivewayArea);

        int drivewayPerimeter = ((drivewayWidth * 2) + (drivewayLength * 2));
        System.out.println("The perimeter of the driveway is " + drivewayPerimeter);

        double drivewayCementCost = drivewayArea * 12.50;
        System.out.printf("Total cost of cement for driveway is $%.2f\n", drivewayCementCost);

        double drivewayFramingCost = drivewayPerimeter * 8.25;
        System.out.printf("Total cost of framing for driveway is $%.2f", drivewayFramingCost);

        double drivewayCost = ((drivewayPerimeter * 8.25) + (drivewayArea * 12.5));
        System.out.printf("The cost of the driveway is %.2f\n ", drivewayCost);

        System.out.println("Please enter the cost of cement per squarefoot");
        double cementCost = Double.parseDouble(scanner.nextLine());

        System.out.println("Please enter the cost of framing per linear foot");
        double framingCost = Double.parseDouble(scanner.nextLine());

        double customDrivewayCost = ((framingCost*drivewayPerimeter) + (cementCost*drivewayArea));

        System.out.printf("Your custom total of driveway is $%.2f", customDrivewayCost);


    }
}
