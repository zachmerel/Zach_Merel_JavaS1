package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount of your mortgage");
        int L = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the term of your mortgage");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the annual interest rate of your mortgage");
        double c = Double.parseDouble(scanner.nextLine());
        double monthlyInterestRate = ((c / 100) / 12);
        double payment = L * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), n))) / ((Math.pow((1 + monthlyInterestRate), n)) - 1));

        System.out.println(payment);

    }
}
