package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int numberOne = Integer.parseInt(scanner.nextLine());

        int answer = ((numberOne + 5) *2);
        System.out.println(answer);

    }
}
