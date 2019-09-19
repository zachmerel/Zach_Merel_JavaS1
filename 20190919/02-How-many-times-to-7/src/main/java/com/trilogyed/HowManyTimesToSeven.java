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
        int numberOfTwos =0;
        int numberOfThrees =0;
        int numberOfFours =0;
        int numberOfFives =0;
        int numberOfSixes =0;
        int numberOfEights =0;
        int numberOfNine =0;
        int numberOfTen =0;
        int numberOfEleven =0;
        int numberOfTwelve =0;



        for (int i = 1; i <= numberOfRolls ; i++) {
            rollValue1 = randomGenerator.nextInt(6) + 1;
            rollValue2 = randomGenerator.nextInt(6) + 1;
            System.out.println("Roll " + i + ": Die 1 - " + rollValue1 + " Die 2 - " + rollValue2 );

            if ((rollValue1 + rollValue2 == 7) && numberOfSevens == 0){
                System.out.println("It took " + i + " rolls to get a seven.");
                numberOfSevens++;
            }else if(rollValue1 + rollValue2 == 7){
                numberOfSevens++;
            }else if(rollValue1 + rollValue2 == 2){
                numberOfTwos++;
            }else if(rollValue1 + rollValue2 == 3){
                numberOfThrees++;
            }else if(rollValue1 + rollValue2 == 4){
                numberOfFours++;
            }else if(rollValue1 + rollValue2 == 5){
                numberOfFives++;
            }else if(rollValue1 + rollValue2 == 6){
                numberOfSixes++;
            }else if(rollValue1 + rollValue2 == 8){
                numberOfEights++;
            }else if(rollValue1 + rollValue2 == 9){
                numberOfNine++;
            }else if(rollValue1 + rollValue2 == 10){
                numberOfTen++;
            }else if(rollValue1 + rollValue2 == 11){
                numberOfEleven++;
            }else if(rollValue1 + rollValue2 == 12){
                numberOfTwelve++;
            }

        }
        System.out.println("Number of sevens rolled " +  numberOfTwos);
        System.out.println("Number of sevens rolled " +  numberOfThrees);
        System.out.println("Number of sevens rolled " +  numberOfFours);
        System.out.println("Number of sevens rolled " +  numberOfFives);
        System.out.println("Number of sevens rolled " +  numberOfSixes);
        System.out.println("Number of sevens rolled " +  numberOfSevens);
        System.out.println("Number of sevens rolled " +  numberOfEights);
        System.out.println("Number of sevens rolled " +  numberOfNine);
        System.out.println("Number of sevens rolled " +  numberOfTen);
        System.out.println("Number of sevens rolled " +  numberOfEleven);
        System.out.println("Number of sevens rolled " +  numberOfTwelve);


    }
}
