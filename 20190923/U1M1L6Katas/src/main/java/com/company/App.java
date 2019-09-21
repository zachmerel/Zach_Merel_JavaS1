package com.company;

import java.util.Arrays;

public class App {
    public static int total(int[] myArray) {
        int sum = 0;

        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        return sum;

    }

    public static int totalOdd(int[] myArray) {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 != 0) {
                sum += myArray[i];
            }
        }
        return sum;
    }

    public static int totalEven(int[] myArray) {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 == 0) {
                sum += myArray[i];
            }
        }
        return sum;
    }

    public static int secondLargestNumber(int[] myArray) {
        int largest;
        int secondLargest;
        if (myArray[0] > myArray[1]) {
             largest = myArray[0];
             secondLargest =myArray[1];
        } else {
             secondLargest = myArray[0];
             largest = myArray[1];
        }
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > largest) {
                secondLargest = largest;
                largest = myArray[i];
            } else if (myArray[i] > secondLargest && myArray[i] != largest) {
                secondLargest = myArray[i];
            }
        }
        return secondLargest;
    }

    public static int[][] splitAtFive(int[] myArray){
        int lessThanFiveCounter = 0;
        int greaterThanOrEqualToFiveCounter = 0;


        for (int i = 0; i <myArray.length ; i++) {
            if(myArray[i] < 5){
                lessThanFiveCounter++;

            }else{
                greaterThanOrEqualToFiveCounter++;
            }

        }
        int[] lessThanFive = new int[lessThanFiveCounter];
        int[] equalToOrGreaterThanFive = new int[greaterThanOrEqualToFiveCounter];

        int lessFiveArrayCounter = 0;
        int equalToOrGreaterThanFiveCounter = 0;

        int[][] multiArray = {lessThanFive, equalToOrGreaterThanFive};

        for (int i = 0; i <myArray.length ; i++) {
            if(myArray[i] < 5){
                lessThanFive[lessFiveArrayCounter] = myArray[i];
                lessFiveArrayCounter++;
            }else{
                equalToOrGreaterThanFive[equalToOrGreaterThanFiveCounter] = myArray[i];
                equalToOrGreaterThanFiveCounter++;
            }
        }

        return multiArray;
    }

    public static String[][] evensAndOdds(String[] myArray) {
        int evenCounter = 0;
        int oddCounter = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 == 0) {
                evenCounter++;
            } else {
                oddCounter++;
            }

        }
        String[] evenArray = new String[evenCounter];
        String[] oddArray = new String[oddCounter];

        int evenArrayCounter = 0;
        int oddArrayCounter = 0;

        String[][] multiArray = {evenArray, oddArray};

        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 == 0) {
                evenArray[evenArrayCounter] = myArray[i];
                evenArrayCounter++;
            } else {
                oddArray[oddArrayCounter] = myArray[i];
                oddArrayCounter++;
            }
        }

        return multiArray;
    }

    public static int[] lessThanFive(int[] myArray){
        int lessThanFiveCounter = 0;
        for (int i = 0; i <myArray.length ; i++) {
            if(myArray[i]<5){
                lessThanFiveCounter++;
            }

        }
        int lessThanFiveArrayCounter = 0;
        int[] lessThanFiveArray = new int[lessThanFiveCounter];
        for (int i = 0; i <myArray.length ; i++) {
            if(myArray[i]<5){
                lessThanFiveArray[lessThanFiveArrayCounter] = myArray[i];
                lessThanFiveArrayCounter++;
            }

        }
        if(lessThanFiveCounter == 0){
            return null;
        }else {
            return lessThanFiveArray;
        }
    }

    public static int[] everyThird(int[] myArray){
        int everyThirdCounter = 0;
        for (int i = 2; i <myArray.length ; i += 3) {
            everyThirdCounter++;
        }

        int everyThirdArrayCounter = 0;
        int[] everyThirdArray = new int[everyThirdCounter];
        for (int i = 2; i < myArray.length; i += 3) {
            everyThirdArray[everyThirdArrayCounter] = myArray[i];
            everyThirdArrayCounter++;
        }
        if(myArray.length<3){
            return null;
        }else {
            return everyThirdArray;
        }
    }

    public static String concatenateString(String[] myArray){
        String returnString = "";
        for (int i = 0; i <myArray.length ; i++) {
           returnString += myArray[i];

        }
        return returnString;
    }

    public static int[] reverse(int[] myArray){

        for(int i = 0; i < myArray.length / 2; i++)
        {
            int elementHolder = myArray[i];
            myArray[i] = myArray[myArray.length - i - 1];
            myArray[myArray.length - i - 1] = elementHolder;
        }

        return myArray;
    }

    public static String[] swapFirstAndLast(String[] myArray){
        String firstElement = myArray[0];
        String lastElement = myArray[myArray.length-1];

        myArray[0] = lastElement;
        myArray[myArray.length-1] = firstElement;

        return myArray;
    }

    public static void main(String[] args) {

    }

}
