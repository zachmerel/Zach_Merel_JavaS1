package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a word.");
        String userWord = scanner.nextLine();

        switch (userWord){
            case "while":
                System.out.println("This is a Java keyword");
                break;
            case "for":
                System.out.println("This is a Java keyword");
                break;
            default:
                System.out.println("This is not a Java keyword");
        }
    }
}
