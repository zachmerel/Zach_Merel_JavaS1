package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int firstNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter another number");
        int secondNumber = Integer.parseInt(scanner.nextLine());

        int answer = firstNumber - secondNumber;
        System.out.println(answer);

    }
}
