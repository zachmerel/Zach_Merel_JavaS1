package com.trilogyed;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int userInput1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a number.");
        int userInput2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a number.");
        int userInput3 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a number.");
        int userInput4 = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter a number.");
        int userInput5 = Integer.parseInt(scanner.nextLine());

        int[] userInputArray = new int[5];
        userInputArray[0] = userInput1;
        userInputArray[1] = userInput2;
        userInputArray[2] = userInput3;
        userInputArray[3] = userInput4;
        userInputArray[4] = userInput5;

        System.out.println(userInputArray[0]);
        System.out.println(userInputArray[1]);
        System.out.println(userInputArray[2]);
        System.out.println(userInputArray[3]);
        System.out.println(userInputArray[4]);
    }
}
