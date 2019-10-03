package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();
        }catch (FileNotFoundException fnfe){
            System.out.println("The following file does not seem to exist: " + fnfe.getMessage() );
        }
        String chosenPet ="";
        int petIndex= 0;
        try {
             petIndex = Pets.choosePet();
        }catch (NumberFormatException nfe){
            System.out.println("Please enter a valid number.");
        }

        try {
            chosenPet = Pets.retrievePet(petIndex);
        }catch (ArrayIndexOutOfBoundsException aiobe){
            System.out.println( "Please choose an available pet.");
        }

        try {
            Pets.writePetToFile(chosenPet);
        }catch(IOException ioe){
            System.out.println("Something went wrong while writing your file.");
        }
    try {
        System.out.println("New saved animals file:");
        Pets.readPetsFromFile();
    }catch(FileNotFoundException fnf){
        System.out.println("Something went wrong while writing your file.");
    }
    finally {
        System.out.println("Have a nice day!");
    }
    }
}
