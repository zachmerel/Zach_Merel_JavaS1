package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesToSeven {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pleas enter the amount of times you would like to roll the dice.");
        int numberOfRolls = Integer.parseInt(scanner.nextLine());


        Random randomGenerator = new Random();

        int rollValue1;
        int rollValue2;
        int numberOfSevens =0;

        for (int i = 1; i <= numberOfRolls ; i++) {
            rollValue1 = randomGenerator.nextInt(6) + 1;
            rollValue2 = randomGenerator.nextInt(6) + 1;
            System.out.println("Roll " + i + ": Die 1 - " + rollValue1 + " Die 2 - " + rollValue2 );

            if ((rollValue1 + rollValue2 == 7) && numberOfSevens == 0){
                System.out.println("It took " + i + " rolls to get a seven.");
                numberOfSevens++;
            }else if(rollValue1 + rollValue2 == 7){
                numberOfSevens++;
            }

        }
        System.out.println("Number of sevens rolled " +  numberOfSevens);
    }
}
