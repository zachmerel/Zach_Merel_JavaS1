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
public class RoasterDaoTest {

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
        Roaster roaster = new Roaster();
        roaster.setName("Foldgers");
        roaster.setStreet("Fake St.");
        roaster.setCity("Chicago");
        roaster.setState("IL");
        roaster.setPostal_code("60613");
        roaster.setPhone("123-456-7890");
        roaster.setEmail("fakeemial@gmail.com");
        roaster.setNote("berries");

        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster2 = roasterDao.getRoaster(roaster.getRoaster_id());

        assertEquals(roaster, roaster2);

        roasterDao.deleteRoaster(roaster.getRoaster_id());

        roaster2 = roasterDao.getRoaster(roaster.getRoaster_id());

        assertNull(roaster2);

    }

    @Test
    public void shouldGetRoasterById() {
        //arrange
        //This one does not have id prop
        Roaster theRoasterToAddToTheDatabse = new Roaster("Foldgers", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries");
        //act
        //this one created in database has been assigned id
        Roaster roasterAfterAddingToTheDatabase = roasterDao.addRoaster(theRoasterToAddToTheDatabse);
        theRoasterToAddToTheDatabse.setRoaster_id(roasterAfterAddingToTheDatabase.getRoaster_id());
        int theId = theRoasterToAddToTheDatabse.getRoaster_id();

        Roaster theRoasterThatIGotFromTheDatabase = roasterDao.getRoaster(theId);
        //assert
        assertEquals(theRoasterToAddToTheDatabse, theRoasterThatIGotFromTheDatabase);
    }

    @Test
    public void shouldGetAllRoasters() {
        //arrange

        Roaster theRoasterToAddToTheDatabse = roasterDao.addRoaster(new Roaster("Foldgers", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries"));
        Roaster theSecondRoasterToAddToTheDatabse = roasterDao.addRoaster(new Roaster("Foldgers", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries"));
        Roaster theThirdRoasterToAddToTheDatabse = roasterDao.addRoaster(new Roaster("Foldgers", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries"));
        //act
        List<Roaster> allRoasters = roasterDao.getAllRoasters();


        //assert
        assertEquals(allRoasters.size(), 3);
    }

    @Test
    public void shouldDeleteRoaster(){
        //Arrange
        Roaster newRoaster = roasterDao.addRoaster(new Roaster("Metropolis", "Rockwell", "Chicago", "IL", "60618", "(773)338 4904", "info@metropoliscofee.com",null));
        Roaster roasterExpected = new Roaster(newRoaster.getRoaster_id(),"Metropolis", "Rockwell", "Chicago", "IL", "60618", "(773)338 4904", "info@metropoliscofee.com",null );
        //Act
        Roaster roasterFromDataBase = roasterDao.getRoaster(newRoaster.getRoaster_id());
        //Assert
        assertEquals(roasterExpected, roasterFromDataBase);
        //Act
        roasterDao.deleteRoaster(newRoaster.getRoaster_id());
        //Assert
        assertEquals(null, roasterDao.getRoaster(newRoaster.getRoaster_id()));

    }

    @Test
    public void shouldUpdateRoaster(){
        //arrange
        Roaster theRoasterToAddToTheDatabse = new Roaster("Foldgers", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries");
        Roaster updatedRoaster = new Roaster("Dunkin", "Fake St.",
                "Chicago", "IL", "60613", "123-456-7890",
                "fakeemial@gmail.com", "berries");
        //act
        //this one created in database has been assigned id
        Roaster roasterAfterAddingToTheDatabase = roasterDao.addRoaster(theRoasterToAddToTheDatabse);
        theRoasterToAddToTheDatabse.setRoaster_id(roasterAfterAddingToTheDatabase.getRoaster_id());
        updatedRoaster.setRoaster_id(roasterAfterAddingToTheDatabase.getRoaster_id());
        int theId = theRoasterToAddToTheDatabse.getRoaster_id();


        roasterDao.updateRoaster(updatedRoaster);

        assertEquals(updatedRoaster, roasterDao.getRoaster(theId));
    }
}