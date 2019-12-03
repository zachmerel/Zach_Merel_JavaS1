package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    List<TShirt> getAllTShirtsByColor( String color);

    List<TShirt> getAllTShirtsBySize( String size);

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);
}
