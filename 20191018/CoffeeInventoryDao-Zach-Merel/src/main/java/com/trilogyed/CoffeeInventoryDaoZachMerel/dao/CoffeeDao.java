package com.trilogyed.CoffeeInventoryDaoZachMerel.dao;

import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Coffee;

import java.util.List;

public interface CoffeeDao {
    Coffee getCoffee(int id);

    List<Coffee> getAllCoffee();

    void deleteCoffee(int id);

    void updateCoffee(Coffee coffee);

    Coffee addCoffee(Coffee coffee);

    List<Coffee> getCoffeeByRoaster(int roaster);

    List<Coffee> getCoffeeByType (String type);

}
