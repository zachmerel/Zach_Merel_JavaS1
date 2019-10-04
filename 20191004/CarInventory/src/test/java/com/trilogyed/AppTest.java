package com.trilogyed;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AppTest {

    private InputStream original;

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
    public void shouldPrintWelcomeMessageToConsole(){
        //arrange
        App.welcome();
        String output = systemOutRule.getLog();

        //act

        //assert
        assertTrue(output.contains("Welcome to the car inventory app \n" +
                "Please choose an option from the below menu \n" +
                "1. Add a car to inventory \n" +
                "2. Delete a car form inventory \n" +
                "3. List cars in inventory \n" +
                "4. Search for a car in inventory"));
    }
}