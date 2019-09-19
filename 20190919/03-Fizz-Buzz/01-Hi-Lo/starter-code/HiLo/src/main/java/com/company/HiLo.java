package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to Hi-Low!");
        System.out.println("Please enter your name");
        String userName = scanner.nextLine();

        System.out.println("OK, " + userName + ", here are the rules:");

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(100) + 1;
//        System.out.println(randomNumber);

        int guessCounter = 0;
        int userGuess;

        do {
            System.out.println("Please guess a number between 1 and 100");
            userGuess = Integer.parseInt(scanner.nextLine());
            guessCounter++;
            if(userGuess < 1 || userGuess > 100){
                System.out.println("The number you have enter is invalid");
            }else if(userGuess < randomNumber){
                System.out.println("Too Low!");
            }else if(userGuess > randomNumber){
                System.out.println("Too high!");
            }
        } while (userGuess != randomNumber);

        System.out.println("It took you " + guessCounter + " guesses to find my number!");

        System.out.println("Congratulations, " + userName + "! You win!");
    }
}
