package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    @Override
    public int readInt(String myInt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an int.");
        int newInt = Integer.parseInt(scanner.nextLine());
        return newInt;
    }
    @Override
    public long readLong(String myLong){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a long");
        long newLong = Long.parseLong(scanner.nextLine());
        return newLong;
    }
    @Override
    public double readDouble(String myDouble){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a double.");
        double newDouble = Double.parseDouble(scanner.nextLine());
        return newDouble;
    }
    @Override
    public float readFloat(String myFloat){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a float.");
        float newFloat = Float.parseFloat(scanner.nextLine());
        return newFloat;
    }

//    @Override
//    public int readInt(String prompt) {
//        return 0;
//    }
//
//    @Override
//    public long readLong(String prompt) {
//        return 0;
//    }
//
//    @Override
//    public double readDouble(String prompt) {
//        return 0;
//    }
//
//    @Override
//    public float readFloat(String prompt) {
//        return 0;
//    }
@Override
    public String readString(String myString){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word.");
        String newString = scanner.nextLine();
        return newString;
    }
}
