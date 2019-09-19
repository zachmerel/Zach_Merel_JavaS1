package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your age.");
        int userAge = Integer.parseInt(scanner.nextLine());

        if (userAge >= 100) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
            System.out.println("You can be president.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
            System.out.println("You are at least a century old");
        } else if (userAge >= 80 && userAge <= 89) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
            System.out.println("You can be president.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
            System.out.println("You are an octogenerian");
        } else if (userAge >= 65) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
            System.out.println("You can be president.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
        } else if (userAge >= 55) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
            System.out.println("You can be president.");
            System.out.println("You are eligible for AARP.");
        } else if (userAge >= 35) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
            System.out.println("You can be president.");
        } else if (userAge >= 21) {
            System.out.println("You can vote!");
            System.out.println("You Can Drink Alcohol.");
        } else if (userAge >= 18) {
            System.out.println("You can vote!");
        }
    }
}
