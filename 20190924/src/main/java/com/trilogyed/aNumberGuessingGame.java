package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class aNumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((10 - 1) + 1) + 1;
        System.out.println("I'm thinking of a number from 1 to 10.");
        Scanner scanner = new Scanner(System.in);
        int userGuess = Integer.parseInt(scanner.nextLine());

        if(userGuess != randomNumber){
            System.out.println("Your guess: " +userGuess );
            System.out.println("Sorry, but I was really thinking of " + randomNumber +".");
        }else{
            System.out.println("Your guess: " +userGuess );
            System.out.println("That's right!  My secret number was " + randomNumber +"!");
        }
    }
}
