package com.trilogyed;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 10.");
        int userInput = Integer.parseInt(scanner.nextLine());



        while (userInput < 1 || userInput > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
             userInput = Integer.parseInt(scanner.nextLine());

        }


        System.out.println(userInput);
    }
}


