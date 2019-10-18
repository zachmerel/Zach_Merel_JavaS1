package com.trilogyed.CoffeeInventoryDaoZachMerel.dao;

import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Roaster;

import java.util.List;

public interface RoasterDao {
    Roaster getRoaster(int id);

    List<Roaster> getAllRoasters();

    void deleteRoaster (int id);

    void updateRoaster (Roaster roaster);

    Roaster addRoaster (Roaster roaster);

}
