package com.trilogyed.CoffeeInventoryDaoZachMerel.dao;

import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Coffee;
import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeDaoTest {

    @Autowired
    public RoasterDao roasterDao;
    @Autowired
    public CoffeeDao coffeeDao;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffees = coffeeDao.getAllCoffee();
        coffees.stream()
                .forEach(coffee -> coffeeDao.deleteCoffee(coffee.getCoffee_id()));
        //delete all the roasters
        List<Roaster> roasters = roasterDao.getAllRoasters();
        roasters.stream()
                .forEach(roaster -> roasterDao.deleteRoaster(roaster.getRoaster_id()));

    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd() {
        //arrange
        //This one does not have id prop
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(123);
        coffee.setName("The Beast");
        coffee.setCount(666);
        coffee.setUnit_price(6.66);
        coffee.setDescription("sinfully strong");
        coffee.setType("ultra dark");


        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee2 = coffeeDao.getCoffee(coffee.getCoffee_id());

        assertEquals(coffee, coffee2);

        coffeeDao.deleteCoffee(coffee.getCoffee_id());

        coffee2 = coffeeDao.getCoffee(coffee.getCoffee_id());

        assertNull(coffee2);

    }

    @Test
    public void shouldGetCoffeeByCoffeeId() {
        //arrange
        //This one does not have id prop
        Coffee theCoffeeToAddToTheDatabse = new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark");
        //act
        //this one created in database has been assigned id
        Coffee coffeeToAddToTheDatabase = coffeeDao.addCoffee(theCoffeeToAddToTheDatabse);
        theCoffeeToAddToTheDatabse.setCoffee_id(coffeeToAddToTheDatabase.getCoffee_id());
        int theId = theCoffeeToAddToTheDatabse.getCoffee_id();

        Coffee theCoffeeThatIGotFromTheDatabase = coffeeDao.getCoffee(theId);
        //assert
        assertEquals(theCoffeeToAddToTheDatabse, theCoffeeThatIGotFromTheDatabase);
    }

    @Test
    public void shouldGetAllCoffee() {
        //arrange

        Coffee theCoffeeToAddToTheDatabse = coffeeDao.addCoffee(new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark"));
        Coffee theSecondCoffeeToAddToTheDatabse = coffeeDao.addCoffee(new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark"));
        Coffee theThirdCoffeeToAddToTheDatabse = coffeeDao.addCoffee(new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark"));
        //act
        List<Coffee> allCoffee = coffeeDao.getAllCoffee();


        //assert
        assertEquals(allCoffee.size(), 3);
    }

    @Test
    public void shouldDeleteCoffee() {
        //Arrange
        Coffee newCoffee = coffeeDao.addCoffee(new Coffee("The Beast", 666, 6.66, "sinfully strong", "ultra dark"));
        Coffee coffeeExpected = new Coffee("The Beast", 666, 6.66, "sinfully strong", "ultra dark");
        //Act
        Coffee coffeeFromDatabase = coffeeDao.getCoffee(newCoffee.getCoffee_id());
        //Assert
        assertEquals(coffeeExpected, coffeeFromDatabase);
        //Act
        coffeeDao.deleteCoffee(newCoffee.getCoffee_id());
        //Assert
        assertEquals(null, coffeeDao.getCoffee(newCoffee.getCoffee_id()));

    }

    @Test
    public void shouldUpdateCoffee() {
        //arrange
        Coffee theCoffeeToAddToTheDatabse = new Coffee(123, "The Beast", 666, 6.66, "sinfully strong", "ultra dark");
        Coffee updatedCoffee = new Coffee(123, "Lucy's Brew", 666, 6.66, "sinfully strong", "ultra dark");
        //act
        //this one created in database has been assigned id
        Coffee cofffeeAfterAddingToTheDatabase = coffeeDao.addCoffee(theCoffeeToAddToTheDatabse);
        theCoffeeToAddToTheDatabse.setCoffee_id(cofffeeAfterAddingToTheDatabase.getCoffee_id());
        updatedCoffee.setCoffee_id(cofffeeAfterAddingToTheDatabase.getCoffee_id());
        int theId = theCoffeeToAddToTheDatabse.getCoffee_id();


        coffeeDao.updateCoffee(updatedCoffee);

        assertEquals(updatedCoffee, coffeeDao.getCoffee(theId));
    }

//    @Test
//    public void shouldGetCoffeeByRoasterId() {
//        //arrange
//        //This one does not have id prop
//        Coffee theCoffeeToAddToTheDatabase = new Coffee(123, "The Beast",
//                666, 6.66, "sinfully strong", "ultra dark");
//        //act
//        //this one created in database has been assigned id
//        Coffee coffeeToAddToTheDatabase = coffeeDao.addCoffee(theCoffeeToAddToTheDatabase);
//        theCoffeeToAddToTheDatabase.setRoaster_id(coffeeToAddToTheDatabase.getRoaster_id());
//        int theId = theCoffeeToAddToTheDatabase.getRoaster_id();
//
////        Coffee theCoffeeThatIGotFromTheDatabase = roasterDao.getRoaster(theId);
//        //assert
//        assertEquals(theCoffeeToAddToTheDatabase, theCoffeeThatIGotFromTheDatabase);
//    }

    @Test
    public void shouldGetCoffeeByType() {
        //arrange
        //This one does not have id prop
        Coffee theCoffeeToAddToTheDatabase = new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark");
        Coffee theSecondCoffeeToAddToTheDatabase = new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark");
        Coffee theThirdCoffeeToAddToTheDatabase = new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "ultra dark");
        Coffee theFourthCoffeeToAddToTheDatabase = new Coffee(123, "The Beast",
                666, 6.66, "sinfully strong", "light roast");
        //act
        List<Coffee> ultraDarkCoffees = new ArrayList<>();
        ultraDarkCoffees.add(theCoffeeToAddToTheDatabase);
        ultraDarkCoffees.add(theSecondCoffeeToAddToTheDatabase);
        ultraDarkCoffees.add(theThirdCoffeeToAddToTheDatabase);

        //assert
        assertEquals(coffeeDao.getCoffeeByType("ultra dark"), ultraDarkCoffees);

    }
}