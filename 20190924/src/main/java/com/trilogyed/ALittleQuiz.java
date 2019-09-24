package com.trilogyed;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("1) Melbourne");
        System.out.println("2) Anchorage");
        System.out.println("3) Juneau");

        int answer1 = Integer.parseInt(scanner.nextLine());
        if(answer1 ==3 ){
            System.out.println("That's right!");
            correctAnswers++;
        }else if (answer1 == 2 || answer1 ==1){
            System.out.println("Incorrect");
            incorrectAnswers++;
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        System.out.println("1) yes");
        System.out.println("2) no");

        int answer2 = Integer.parseInt(scanner.nextLine());
        if(answer2 ==2 ){
            System.out.println("That's right!");
            correctAnswers++;
        }else if(answer2 == 1){
            System.out.println("Incorrect");
            incorrectAnswers++;
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("1) 5");
        System.out.println("2) 11");
        System.out.println("3) 15/3");

        int answer3 = Integer.parseInt(scanner.nextLine());
        if(answer3 ==2 ){
            System.out.println("That's correct!");
            correctAnswers++;
        }else if (answer3 == 1 || answer1 ==3){
            System.out.println("Incorrect");
            incorrectAnswers++;
        }

        System.out.println("Overall, you got " + correctAnswers +  " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }
}
