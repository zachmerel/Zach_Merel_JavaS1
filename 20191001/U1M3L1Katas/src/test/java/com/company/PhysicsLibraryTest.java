package com.company;

import com.company.PhysicsLibrary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhysicsLibraryTest {
    private PhysicsLibrary calculation;

    @Before
    public void setUp() {
        calculation = new PhysicsLibrary();
    }

    @Test
    public void shouldMultiplyTwoPositiveDoubles(){
        assertEquals(5,calculation.calculateForce(5,1),.001);
        assertEquals(5,calculation.calculateDistance(5,1),.001);
        assertEquals(0,calculation.calculateForce(0,5),.001);
        assertEquals(0,calculation.calculateForce(5,0),.001);
    }

    @Test
    public void shouldMultiplyTwoNegativeDoubles(){
        assertEquals(5,calculation.calculateForce(-5.0,-1.0),.001);
        assertEquals(5,calculation.calculateDistance(-5.0,-1.0),.001);
    }

    @Test
    public void shouldDivideTwoPositiveDoubles(){
        assertEquals(2,calculation.calculateMass(10.0,5.0),.001);
        assertEquals(0,calculation.calculateMass(10,0),.001);
    }

    @Test
    public void shouldDivideTwoNegativeDoubles(){
        assertEquals(2,calculation.calculateMass(10.0,5.0),.001);
        assertEquals(0,calculation.calculateMass(10,0),.001);
    }

    @Test
    public void shouldDivideTheDifferencesOfTwoSetsOfPositiveIntegers(){
        assertEquals(1,calculation.calculateVelocity(10.0,5.0,10.0,5.0),.001);
        assertEquals(1,calculation.calculateAcceleration(10.0,5.0,10.0,5.0),.001);
    }

    @Test
    public void shouldDivideTheNegativeDifferencesOfTwoSetsOfIntegers(){
        assertEquals(1,calculation.calculateVelocity(5.0,6.0,5.0,6.0),.001);
        assertEquals(1,calculation.calculateAcceleration(5.0,6.0,5.0,6.0),.001);
    }

    @Test
    public void shouldReturnZeroWhenDividedByZero(){
        assertEquals(0,calculation.calculateAcceleration(6.0,5.0,6.0,6.0),.001);
        assertEquals(0,calculation.calculateVelocity(6.0,5.0,6.0,6.0),.001);
    }

    @Test
    public void shouldReturnZeroWhenDivideZero(){
        assertEquals(0,calculation.calculateVelocity(6.0,6.0,6.0,5.0),.001);
        assertEquals(0,calculation.calculateAcceleration(6.0,6.0,6.0,5.0),.001);
    }
}
