package com.trilogyed;

import java.util.Arrays;
import java.util.List;

public class PrimeChecker {
    /**
     * Write tests for, and then implement the checkPrime method at the end of this file.
     * checkPrime returns true if the argument passed to it is a prime number. It returns false if the argument
     * passed to it is not a prime number.
     *
     * A prime number is a whole number greater than 1 whose only factors are 1 and itself.
     * A factor is a whole numbers that can be divided evenly into another number.
     * The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29.
     *
     *
     * -2 is not prime      because it is not greater than 1
     * -1 is not prime      because it is not greater than 1
     * 0 is not prime       because it is not greater than 1
     * 1 is not prime       because it is not greater than 1
     * 2 is prime           because its only factors are 1 and itself
     * 3 is prime           because its only factors are 1 and itself
     * 4 is not prime       because 2 is a factor in addition to 1 and 4
     * 5 is prime           because its only factors are 1 and itself
     * 6 is not prime       because 2 is a factor in addition to 1 and itself (and 3)
     * 7 is prime           because its only factors are 1 and itself
     * 8 is not prime       because 2 is a factor in addition to 1 and itself (and 4)
     * 9 is not prime       because 3 is a factor in addition to 1 and itself
     * 23 is prime          because its only factors are 1 and itself
     * 24 is not prime      because 2 is a factor in addition to 1 and itself (and 3, 4, 6, 8, and 12)
     * 437 is not prime     because 19 is a factor in addition to 1 and itself (and 23)
     * 439 is prime         because its only factors are 1 and itself
     *
     * Prime numbers are used in cryptography, and in other applications.
     * They are a favorite topic of interviewers, so make yourself comfortable with them.
     */

    public static void main(String[] args) {
        checkSomePrimeNumbers(Arrays.asList(2, 3, 4, 9865787, 80730017, 80730029, 80730037, -5, 0));
        printPrimesBetweenXAndY(1,450);
    }

    // You don't have to do anything with this method. It's here for fun!
    public static void checkSomePrimeNumbers(List<Integer> listToCheck) {
        System.out.println("Checking some prime numbers... ");
        PrimeChecker primeChecker = new PrimeChecker();
        for (Integer i : listToCheck) {
            System.out.println("" + i + " is " + (primeChecker.checkPrime(i) ? "" : "not ") + "a prime number.");
        }
    }

    // You don't have to do anything with this method. It's ALSO here for fun!
    public static void printPrimesBetweenXAndY(int x, int y) {
        PrimeChecker primeChecker = new PrimeChecker();
        for (int i = x; i <= y; i++) {
            if (primeChecker.checkPrime(i)) {
                System.out.println(i + " is prime.");
            }
        }
    }

    public boolean checkPrime(int x) {
        // put your implementation here.
        if(x <= 0){
            return false;
        }else{
            return true;
        }

    }

}
