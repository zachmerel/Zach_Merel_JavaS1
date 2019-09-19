package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.println("Enter your favorite programming language");
            userAnswer = scanner.nextLine();
            if (userAnswer.equals("Java")) {
                System.out.println("That's what I was looking for! Java is definitely the answer!");
            }
        }while (!"Java".equals(userAnswer)) ;

    }
    }

