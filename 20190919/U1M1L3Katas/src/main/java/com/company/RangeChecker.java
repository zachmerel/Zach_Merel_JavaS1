package com.company;
        import java.util.Scanner;
public class RangeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        do {
            System.out.println("Enter a number between 15 and 32.");
            userNumber = Integer.parseInt(scanner.nextLine());
            if (userNumber >= 15 && userNumber <= 32) {
                System.out.println(userNumber);
            }
        }while (userNumber < 15 || userNumber > 32) ;
    }
}