package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name");
        String lastName = scanner.nextLine();

        System.out.println("Please enter your email");
        String email = scanner.nextLine();

        System.out.println("Please enter your Twitter handle");
        String twitterHandle = scanner.nextLine();

        System.out.println("Please enter your age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter your Country");
        String country = scanner.nextLine();

        System.out.println("Please enter your profession");
        String profession = scanner.nextLine();

        System.out.println("Please enter your favorite operating system");
        String favoriteOperatingSystem = scanner.nextLine();

        System.out.println("Please enter your favorite programming language");
        String favoriteProgrammingLanguage = scanner.nextLine();

        System.out.println("Please enter your favorite computer scientist");
        String favoriteComputerScientist = scanner.nextLine();

        System.out.println("Please enter your favorite keyboard shortcut");
        String favoriteKeyboardShortcut = scanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String computerBuild = scanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String superhero = scanner.nextLine();

        System.out.println("Your information:");
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(twitterHandle);
        System.out.println(age);
        System.out.println(country);
        System.out.println(profession);
        System.out.println(favoriteOperatingSystem);
        System.out.println(favoriteProgrammingLanguage);
        System.out.println(favoriteComputerScientist);
        System.out.println(favoriteKeyboardShortcut);
        System.out.println(computerBuild);
        System.out.println(superhero);


    }
}
