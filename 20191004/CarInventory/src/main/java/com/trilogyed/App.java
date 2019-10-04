package com.trilogyed;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Methods myCarInventoryMethods = new Methods();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            welcome();
            myCarInventoryMethods.startingInventory();
            int userInput = Integer.parseInt(scanner.nextLine());
            switch(userInput){
                case 1:
                    System.out.println("Enter your car's information");
                    System.out.print("Make: ");
                    String userMake = scanner.nextLine();
                    System.out.print("Model: ");
                    String userModel = scanner.nextLine();
                    System.out.print("year: ");
                    int userYear = Integer.parseInt(scanner.nextLine());
                    System.out.print("Color: ");
                    String userColor = scanner.nextLine();
                    System.out.print("Mileage: ");
                    int userMilage = Integer.parseInt(scanner.nextLine());

                    Car car = new Car(userMake, userModel,userYear,userColor,userMilage);
                    myCarInventoryMethods.add(car);

                    break;
                case 2:
                    System.out.println("Choose a car to delete: ");
                    myCarInventoryMethods.list();
                    System.out.println("Choose a number of car to delete");
                    int userDeleteNumber = Integer.parseInt(scanner.nextLine());
                    myCarInventoryMethods.delete(userDeleteNumber);
                    break;
                case 3:
                    System.out.println("Here is a list of cars in inventory: ");
                    myCarInventoryMethods.list();

                    break;
                case 4:
                    System.out.println("How do you want to search for a car? Please enter a number from the following list");
                    System.out.println("1. Make \n" +
                            "2. Model \n" +
                            "3. Color \n" +
                            "4. Year \n" +
                            "5. Mileage \n");
                    int userSearchNumber = Integer.parseInt(scanner.nextLine());
                    switch (userSearchNumber){
                        case 1:
                            System.out.println("Enter a make");
                            String userSearchMake = scanner.nextLine();
                            myCarInventoryMethods.searchMake(userSearchMake);
                            break;
                        case 2:
                            System.out.println("Enter a model");
                            String userSearchModel = scanner.nextLine();
                            myCarInventoryMethods.searchModel(userSearchModel);

                            break;
                        case 3:
                            System.out.println("Enter a color ");
                            String userSearchColor = scanner.nextLine();
                            myCarInventoryMethods.searchColor(userSearchColor);
                            break;
                        case 4:
                            System.out.println("Enter a year");
                            int userSearchYear = Integer.parseInt(scanner.nextLine());
                            myCarInventoryMethods.searchYear(userSearchYear);
                            break;
                        case 5:
                            System.out.println("Enter Mileage");
                            int userSearchMileage = Integer.parseInt(scanner.nextLine());
                            myCarInventoryMethods.searchMilage(userSearchMileage);
                            break;
                    }
                    break;
            }
//            Car car1 = new Car("Chevy", "Tahoe", 2008, "Red", 12000);
//            Car car2 = new Car("Jeep", "Wranger", 1999, "Green", 100000);
//
//
//            Map<Integer, Car> carInventory = new HashMap<>();
//            carInventory.put(0, car0);
//            carInventory.put(1, car1);
//            carInventory.put(2, car2);


            //Methods will get instantiated here


        }
        }
    public  static String welcome(){
        System.out.println("Welcome to the car inventory app \n" +
                "Please choose an option from the below menu \n" +
                "1. Add a car to inventory \n" +
                "2. Delete a car form inventory \n" +
                "3. List cars in inventory \n" +
                "4. Search for a car in inventory");


        return null;
    }
    }

