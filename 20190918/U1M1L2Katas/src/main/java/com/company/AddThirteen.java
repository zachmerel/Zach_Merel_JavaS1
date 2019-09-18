package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int number1 = Integer.parseInt(scanner.nextLine());

        int answer = number1 + 13;
        System.out.println(answer);
    }
}
