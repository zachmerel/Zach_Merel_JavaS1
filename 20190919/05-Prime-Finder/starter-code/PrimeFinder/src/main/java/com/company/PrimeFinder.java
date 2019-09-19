package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number.");
        int userNumber = Integer.parseInt(scanner.nextLine());

        int i = 0;
        int j = 0;
        String primeNumbers = "";
        for (i = 1; i <= userNumber; i++) {
            int primeCounter = 0;
            for (j = i; j >= 1; j--) {
                if (i % j == 0) {
                    primeCounter++;
                }
            }
            if (primeCounter == 2) {
                primeNumbers = primeNumbers + i;
                System.out.println(i);
            }
        }
    }
}

