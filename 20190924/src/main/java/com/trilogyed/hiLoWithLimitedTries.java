package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class hiLoWithLimitedTries {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((100 - 1) + 1) + 1;
        int guessCounter = 1;
        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
        Scanner scanner = new Scanner(System.in);
        int userGuess = Integer.parseInt(scanner.nextLine());

        while(userGuess != randomNumber && guessCounter <= 6 ){
            if(userGuess < randomNumber){
                System.out.println("Sorry, you are too low.");
                guessCounter++;
                userGuess = Integer.parseInt(scanner.nextLine());
            }else if(userGuess > randomNumber){
                System.out.println("Sorry, that guess is too high.");
                guessCounter++;
                userGuess = Integer.parseInt(scanner.nextLine());
            }
        }

        if(userGuess == randomNumber){
            System.out.println("You guessed it!  What are the odds?!?");
        }else if(guessCounter == 7) {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
        }

    }
}
