package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter salary for player 1");
        int player1Salary = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter salary for player 2");
        int player2Salary = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter salary for player 3");
        int player3Salary = Integer.parseInt(scanner.nextLine());

        int totalSalaries = (player1Salary + player2Salary + player3Salary);
        System.out.println("The total salaries for all three players is: " + totalSalaries);

        if (totalSalaries > 40000000){
            double luxuryTax = ((totalSalaries - 40000000) * .18);
            System.out.println("The team's luxury tax is: " + luxuryTax);

        }

    }
}
