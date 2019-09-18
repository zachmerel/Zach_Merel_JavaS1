package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int numberOne = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter another number");
        int numberTwo = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a third number");
        int numberThree = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a fourth number");
        int numberFour = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a fifth number");
        int numberFive = Integer.parseInt(scanner.nextLine());

        int sum = (numberOne + numberTwo + numberThree + numberFour + numberFive);

        System.out.format("The sum is: " + sum);
        System.out.println();

    }
}
