package com.trilogyed.CarLotDaoZachMerel.dao;

import com.trilogyed.CarLotDaoZachMerel.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarInventoryDaoTest {

    @Autowired
    private CarLotInventoryDao dao;
    @Before
    public void setUp() throws Exception {
        List<Car> allCars = dao.getAllCars();

        allCars.stream()
                .forEach(car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        //arrange
        //This one does not have id prop
        Car theCarToAddToTheDatabse = new Car( "Tesla", "S", "2019", "matte black");
        //act
        //this one created in database has been assigned id
        Car carAfterAddingToTheDatabase = dao.addCar(theCarToAddToTheDatabse);
        theCarToAddToTheDatabse.setId(theCarToAddToTheDatabse.getId());

        //assert
        assertEquals(theCarToAddToTheDatabse, carAfterAddingToTheDatabase);
    }

    @Test
    public void shouldGetCarById (){
        //arrange
        //This one does not have id prop
        Car theCarToAddToTheDatabse = new Car( "Tesla", "S", "2019", "matte black");
        //act
        //this one created in database has been assigned id
        Car carAfterAddingToTheDatabase = dao.addCar(theCarToAddToTheDatabse);
        theCarToAddToTheDatabse.setId(carAfterAddingToTheDatabase.getId());
        int theId = theCarToAddToTheDatabse.getId();

        Car theCarThatIGotFromTheDatabase = dao.getCar(theId);
        //assert
        assertEquals(theCarToAddToTheDatabse, theCarThatIGotFromTheDatabase);
    }

    @Test
    public void shouldGetAllCars(){
        //arrange
        Car theFirstCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte black"));
        Car theSecondCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte red"));
        Car theThirdCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte blue"));

        //act
        List<Car> allCars = new ArrayList<>();
        allCars.add(theFirstCarToAddToTheDatabse);
        allCars.add(theSecondCarToAddToTheDatabse);
        allCars.add(theThirdCarToAddToTheDatabse);

        //assert
        assertEquals(dao.getAllCars(),allCars);
    }

    @Test
    public void shouldGetAllCarsByMake(){
        Car theFirstCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte black"));
        Car theSecondCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte red"));
        Car theThirdCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte blue"));


        //act
        List<Car> allCars = new ArrayList<>();
        allCars.add(theFirstCarToAddToTheDatabse);
        allCars.add(theSecondCarToAddToTheDatabse);
        allCars.add(theThirdCarToAddToTheDatabse);


        //assert
        assertEquals(dao.getCarByMake("BMW"),allCars);

    }

    @Test
    public void shouldGetAllCarsByColor(){
        Car theFirstCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte black"));
        Car theSecondCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte red"));
        Car theThirdCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte blue"));


        //act
        List<Car> allCars = new ArrayList<>();
        allCars.add(theFirstCarToAddToTheDatabse);



        //assert
        assertEquals(dao.getCarByColor("matte black"),allCars);

    }

    @Test
    public void shouldDeleteMotorCycle(){
        Car theFirstCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte black"));
        Car theSecondCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte red"));
        Car theThirdCarToAddToTheDatabse = dao.addCar(new Car( "BMW", "M5", "2019", "matte blue"));
        List<Car> allCars = new ArrayList<>();
        allCars.add(theFirstCarToAddToTheDatabse);
        allCars.add(theSecondCarToAddToTheDatabse);

        dao.deleteCar(theFirstCarToAddToTheDatabse.getId());



        //assert
        assertEquals(dao.getAllCars().size(),allCars.size());

    }

    @Test
    public void shouldUpdateMotorcycle(){
        //arrange
        Car theCarToAddToTheDatabse = new Car("BMW", "M5", "2019", "matte black");
        Car updatedCar = new Car("BMW", "M5", "2019", "pearl white");
        //act
        //this one created in database has been assigned id
        Car carAfterAddingToTheDatabase = dao.addCar(theCarToAddToTheDatabse);
        theCarToAddToTheDatabse.setId(carAfterAddingToTheDatabase.getId());
        updatedCar.setId(carAfterAddingToTheDatabase.getId());
        int theId = theCarToAddToTheDatabse.getId();


        dao.updateCar(updatedCar);

        assertEquals(updatedCar, dao.getCar(theId));
    }
}