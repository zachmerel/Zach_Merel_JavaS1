package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        double numberOne = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter another number");
        double numberTwo = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter a third number");
        double numberThree = Double.parseDouble(scanner.nextLine());

        double total = (numberOne * numberTwo * numberThree) ;

        System.out.format("The sum is: %.2f \n", total);

    }
}