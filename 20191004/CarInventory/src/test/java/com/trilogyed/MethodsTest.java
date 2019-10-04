package com.trilogyed;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MethodsTest {

    private InputStream original;
    Methods myCarInventoryMethods = new Methods();

    @Before
    public void setUp() throws Exception {
        systemOutRule.clearLog();
        original = System.in;
    }

    @After
    public void resetIn() {
        System.setIn(original);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldAddACarToInventory() {
        //arrange
        Methods methods = new Methods();
        methods.list();
        Map<Integer, Car> carInventory = new HashMap<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Chevy", "Tahoe", 2008, "Red", 12000);
        carInventory.put(0, car0);
        carInventory.put(1, car1);
        carInventory.put(4, car1);

        //act
        Map<Integer, Car> whatIGotBack = myCarInventoryMethods.add(car1);

        //assert
        assertEquals(carInventory, whatIGotBack);
    }

    @Test
    public void shouldDeleteACarFromInventory() {
        //arrange
        Methods methods = new Methods();
        methods.list();
        Map<Integer, Car> carInventory = new HashMap<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Chevy", "Tahoe", 2008, "Red", 12000);
        carInventory.put(0, car0);
        carInventory.put(1, car1);

        //act
        Map<Integer, Car> whatIGotBack = myCarInventoryMethods.delete(4);

        //assert
        assertEquals(carInventory, whatIGotBack);
    }

    @Test
    public void shouldListCarInInventory() {
        //arrange
        Methods methods = new Methods();
        methods.list();
        Map<Integer, Car> carInventory = new HashMap<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Chevy", "Tahoe", 2008, "Red", 12000);
        Car car2 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carInventory.put(0, car0);
        carInventory.put(1, car1);
        carInventory.put(2, car2);


        //act
        Map<Integer, Car> whatIGotBack = Methods.getCarInventory();


        //assert
        assertEquals(carInventory, whatIGotBack);
    }

    @Test
    public void shouldSearchForCarsInventoryByModel() {
        //arrange
        List<Car> carList = new ArrayList<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carList.add(0, car0);
        carList.add(1, car1);


        //act
        List<Car> whatIGotBack = myCarInventoryMethods.searchModel("Accord");


        //assert
        assertEquals(carList, whatIGotBack);
    }

    @Test
    public void shouldSearchForCarsInventoryByMake() {
        //arrange
        List<Car> carList = new ArrayList<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carList.add(0, car0);
        carList.add(1, car1);

        //act
        List<Car> whatIGotBack = myCarInventoryMethods.searchMake("Honda");


        //assert
        assertEquals(carList, whatIGotBack);
    }

    @Test
    public void shouldSearchForCarsInventoryByYear() {
        //arrange
        List<Car> carList = new ArrayList<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Chevy", "Tahoe", 2011, "Red", 12000);
        carList.add(0, car0);
        carList.add(1, car1);


        //act
        List<Car> whatIGotBack = myCarInventoryMethods.searchYear(2011);


        //assert
        assertEquals(carList, whatIGotBack);
    }

    @Test
    public void shouldSearchForCarsInventoryByColor() {
        //arrange
        List<Car> carList = new ArrayList<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carList.add(0, car0);
        carList.add(1, car1);


        //act
        List<Car> whatIGotBack = myCarInventoryMethods.searchColor("Black");


        //assert
        assertEquals(carList, whatIGotBack);
    }

    @Test
    public void shouldSearchForCarsInventoryByMileage() {
        //arrange
        List<Car> carList = new ArrayList<>();
        Car car0 = new Car("Honda", "Accord", 2001, "Black", 80000);
        Car car1 = new Car("Honda", "Accord", 2011, "Black", 80000);
        carList.add(0, car0);
        carList.add(1, car1);


        //act
        List<Car> whatIGotBack = myCarInventoryMethods.searchMilage(80000);


        //assert
        assertEquals(carList, whatIGotBack);
    }
}