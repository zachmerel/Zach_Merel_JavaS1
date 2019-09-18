package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        double numberOne = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter another number");
        double numberTwo = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter a third number");
        double numberThree = Double.parseDouble(scanner.nextLine());

        double avg = (numberOne + numberTwo + numberThree) / 3;

        System.out.format("The average is: %.2f \n", avg);

    }
}
