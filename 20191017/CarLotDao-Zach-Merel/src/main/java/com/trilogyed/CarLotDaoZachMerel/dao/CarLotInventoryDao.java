package com.trilogyed.CarLotDaoZachMerel.dao;

import com.trilogyed.CarLotDaoZachMerel.model.Car;

import java.util.List;

public interface CarLotInventoryDao {
    Car getCar(int id);

    List<Car> getAllCars();

    void deleteCar(int id);

    void updateCar(Car car);

    Car addCar (Car car);

    List<Car> getCarByMake (String make);

    List<Car> getCarByColor (String color);
}
