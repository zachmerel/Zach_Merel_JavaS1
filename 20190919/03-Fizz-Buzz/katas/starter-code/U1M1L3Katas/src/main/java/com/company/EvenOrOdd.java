package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number.");
        int userNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(userNumber%2);

        if ((userNumber%2) >= 1){
            System.out.println("This is an odd number.");
        }else{
            System.out.println("This is an even number.");
        }

    }
}
