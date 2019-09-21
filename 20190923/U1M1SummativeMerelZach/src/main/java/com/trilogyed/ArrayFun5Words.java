package com.trilogyed;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a word");
        String userInput1 = scanner.nextLine();
        System.out.println("Please enter a word");
        String userInput2 = scanner.nextLine();
        System.out.println("Please enter a word");
        String userInput3 = scanner.nextLine();
        System.out.println("Please enter a word");
        String userInput4 = scanner.nextLine();
        System.out.println("Please enter a word");
        String userInput5 = scanner.nextLine();

        String[] userInput = new String[]{userInput1, userInput2, userInput3, userInput4, userInput5};
        System.out.println(userInput[0]);
        System.out.println(userInput[1]);
        System.out.println(userInput[2]);
        System.out.println(userInput[3]);
        System.out.println(userInput[4]);


    }
}
