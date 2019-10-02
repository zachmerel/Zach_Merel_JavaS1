package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class App {

    public static int total (List<Integer> numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }



    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0,  strings.get(strings.size() - 1) );
        strings.set( strings.size() - 1, temp);

        return strings;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {

        ArrayList<Integer> reversed = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get( numbers.size()- (i + 1) ));
        }

        return reversed;
    }

    public static ArrayList<Integer> lessThanFive(ArrayList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        ArrayList<Integer> lessThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.add(num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }

//    //challenge
//    public static ArrayList<ArrayList<Integer>> splitAtFive(ArrayList<Integer> numbers) {
//        int numLessThanFive = 0;
//        int numMoreThanFive = 0;
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            } else {
//                numMoreThanFive++;
//            }
//        }
//
//        ArrayList<Integer> lessThan = new ArrayList<>();
//        ArrayList<Integer> moreThan = new ArrayList<>();
//
////        int[] lessThan = new int[numLessThanFive];
////        int[] moreThan = new int[numMoreThanFive];
//
//
//        for(int num : numbers) {
//
//            // subtracting numLessThanFive from length then decrementing numLessThanFive
//            // allows us to go from 0 to length - 1 in order without additional variables
//            // same with numMoreThanFive
//            if ( num < 5 ) {
//                lessThan.add(num);
////                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            } else {
//                moreThan.add(num);
////                moreThan[moreThan.length - numMoreThanFive] = num;
//                numMoreThanFive--;
//            }
//        }
//
//        return ArrayList<ArrayList<lessThan,moreThan>>;
//    }

    // Challenge
//    public static List<List<String>> evensAndOdds(List<List> strings) {
//
//        //leveraging integer division
//        String[] odds = new String[ strings.length/2 ];
//
//        // Set evens to null for reassignment below
//        String[] evens = null;
//
//        // again leveraging integer division
//        // if it's already of even length, we're good
//        // but if it's of odd length, there's one more even index than odd
//        if (strings.length % 2 == 0) {
//            evens = new String[ strings.length/2];
//        } else {
//            evens = new String[ strings.length/2 + 1];
//        }
//
//        for(int i = 0; i < strings.length; i++) {
//            int currIndex = i/2;
//            if( i % 2 == 0 ) {
//                evens[currIndex] = strings[i];
//            } else {
//                odds[currIndex] = strings[i];
//            }
//        }
//
//        return new String[][] { evens, odds };
//    }
}
