package com.trilogyed;

import java.util.Random;

public class HowManyTimesToSeven {
    public static void main(String[] args) {

        Random randomGenerator = new Random();

        int rollValue1;
        int rollValue2;
        int numberOfSevens =0;

        for (int i = 1; i <= 100 ; i++) {
            rollValue1 = randomGenerator.nextInt(6) + 1;
            rollValue2 = randomGenerator.nextInt(6) + 1;

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
