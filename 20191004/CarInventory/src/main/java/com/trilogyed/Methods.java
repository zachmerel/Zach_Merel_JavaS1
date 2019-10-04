package com.trilogyed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Methods {


    public static Map<Integer, Car> carInventory = new HashMap<>();

    public static Map<Integer, Car> getCarInventory() {
        return carInventory;
    }


    public Map<Integer, Car> add(Car car) {
        carInventory.put(Car.getCarCounter(), car);
        return carInventory;

    }

    public Map<Integer, Car> delete(int carNumber) {
        carInventory.remove(carNumber);
        return carInventory;
    }
    public static Map<Integer, Car> startingInventory() {
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Chevy", "Tahoe", 2011, "Red", 12000);
        Car car2 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carInventory.put(0, car0);
        carInventory.put(1, car1);
        carInventory.put(2, car2);
        return carInventory;
    }

    public Map<Integer, Car> list() {
        System.out.println("The following is a list of cars: ");
        for (Map.Entry<Integer, Car> x : carInventory.entrySet()) {
            System.out.println(x + " \n");
        }
        return carInventory;
    }

    public List<Car> searchMake(String make) {
        List<Car> listOfCars = new ArrayList<>();
        List<Car> printListOfCars = new ArrayList<>();
        listOfCars.addAll(carInventory.values());
        for (Car x : listOfCars) {
            if (x.getMake().equals(make)) {
                printListOfCars.add(x);
            }
        }
        System.out.println(printListOfCars);
        return printListOfCars;

    }

    public List<Car> searchModel(String model) {
        startingInventory();
        List<Car> listOfCars = new ArrayList<>();
        List<Car> printListOfCars = new ArrayList<>();
        listOfCars.addAll(carInventory.values());
        for (Car x : listOfCars) {
            if (x.getModel().equals(model)) {
                printListOfCars.add(x);
            }
        }
        System.out.println(printListOfCars);
        return printListOfCars;
    }

    public List<Car>  searchColor(String color) {
        List<Car> listOfCars = new ArrayList<>();
        List<Car> printListOfCars = new ArrayList<>();
        listOfCars.addAll(carInventory.values());
        for (Car x : listOfCars) {
            if (x.getColor().equals(color)) {
                printListOfCars.add(x);
            }
        }
        System.out.println(printListOfCars);
        return printListOfCars;
    }

    public List<Car>  searchYear(int year) {
        List<Car> listOfCars = new ArrayList<>();
        List<Car> printListOfCars = new ArrayList<>();
        listOfCars.addAll(carInventory.values());
        for (Car x : listOfCars) {
            if (x.getYear() == year) {
                printListOfCars.add(x);
            }
        }
        System.out.println(printListOfCars);
        return printListOfCars;
    }

    public List<Car>  searchMilage(int mileage) {
        List<Car> listOfCars = new ArrayList<>();
        List<Car> printListOfCars = new ArrayList<>();
        listOfCars.addAll(carInventory.values());
        for (Car x : listOfCars) {
            if (x.getMileage() >= mileage + 5000) {
                printListOfCars.add(x);
            }
        }
        System.out.println(printListOfCars);
        return printListOfCars;
    }
}
