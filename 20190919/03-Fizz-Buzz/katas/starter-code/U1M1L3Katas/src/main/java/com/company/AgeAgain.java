package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your age");
        int userAge = Integer.parseInt(scanner.nextLine());

        if(userAge < 14){
            System.out.println("What grade are you in?");
            String userGrade = scanner.nextLine();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        }else if( userAge >= 14 && userAge <= 18){
            System.out.println("Are you planning on going to college?");
            String collegeAnswer = scanner.nextLine();

            if (collegeAnswer.equals("yes")){
                System.out.println("Which college?");
                String collegeName = scanner.nextLine();
                System.out.println(collegeName + " is a great school!");
            }else if(collegeAnswer.equals("no")){
                System.out.println("What do you want to do after highschool?");
                String userLifePlan = scanner.nextLine();
                System.out.println("Wow, " + userLifePlan +  " sounds like a plan!");
            }

        }else if (userAge > 18){
            System.out.println("What is your job?");
            String userJob = scanner.nextLine();
            System.out.println(userJob + " sounds like a great job!");
        }

    }
}
