package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class aNumberGuessingGameWithACounter {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((10 - 1) + 1) + 1;
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        Scanner scanner = new Scanner(System.in);
        int userGuess = Integer.parseInt(scanner.nextLine());
        int guessCounter = 1;

        while(userGuess != randomNumber){
            System.out.println("That is incorrect. Guess again.");
            guessCounter++;
            userGuess = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you " + guessCounter + " tries.");
    }
}
