package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> printKeys) {
        for (String theMapKey : printKeys.keySet()) {
            System.out.println(theMapKey);
        }
    }

    public void printValues(Map<String, String> printValues) {
        for (String theMapValue : printValues.values()) {
            System.out.println(theMapValue);
        }
    }

    public void printKeysAndValues(Map<String, String> printKeysAndValues) {
        Set<Map.Entry<String, String>> myEntrySet = printKeysAndValues.entrySet();
        for (Map.Entry<String, String> entry : myEntrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> carsMap) {
        carsMap.put("Ford Explorer", 2012);
        carsMap.put("Smart Fortwo", 2013);
        carsMap.remove("Jeep Wrangler");

        return carsMap;
    }

    public Map<String, List<Car>> listCars(List<Car> carList) {
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMake() == "Toyota") {
                toyotaList.add(car);
            } else if (car.getMake() == "Ford") {
                fordList.add(car);
            } else if (car.getMake() == "Honda") {
                hondaList.add(car);
            }


        }

        Map<String, List<Car>> mapOfCars = new HashMap<>();
        mapOfCars.put("Toyota", toyotaList);
        mapOfCars.put("Ford", fordList);
        mapOfCars.put("Honda", hondaList);

        return mapOfCars;
    }
}
