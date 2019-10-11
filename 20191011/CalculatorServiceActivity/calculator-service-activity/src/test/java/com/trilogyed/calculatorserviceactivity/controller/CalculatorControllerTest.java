package com.trilogyed.calculatorserviceactivity.controller;

import com.trilogyed.calculatorserviceactivity.Calculator;
import com.trilogyed.calculatorserviceactivity.models.NumberPair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
private Calculator calculator;
@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)

public class CalculatorControllerTest {

    static Calculator tester;

    static double numberA;
    static double numberB;

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculatorController cc;


    @Before
    public void setUp() throws Exception {

        tester = new Calculator();

        numberA = 5;
        numberB = 10;

    }

    @Test
    public void shouldCreateANewAnswer() throws Exception {
        // arrange
        NumberPair inputAndOutRecordForPut = new NumberPair(2,"a");
        String inputJson = (inputAndOutRecordForPut);
        String outputJson = mapper.writeValueAsString(new Record("Boyz II Men", "Cooleyhighharmony", "1991", 5));

        // act
        mockMvc.perform(
                post("/records")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().json(outputJson));         // our json should match
    }

    @Test
    public void shouldGive422Status_whenAnOperandIsNotANumber() throws Exception {
        // arrange
        NumberPair inputAndOutRecordForPut = new NumberPair(2,"a");
        String inputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        String expectedMessage = "You must enter two valid numbers";
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);

        mockMvc.perform(
                put("/add")     // act
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())                 // assert
                .andExpect(content().string(containsString(expectedMessage)));
    }

    @Test
    public void shouldAddTwoInts(){
        assertEquals(15, tester.add(numberA, numberB), 0.0001);
    }

    @Test
    public void shouldSubtractTwoInts(){
        assertEquals(-5, tester.subtract(numberA, numberB), 0.0001);
    }

    @Test
    public void shouldMultipleTwoInts(){
        assertEquals(50, tester.mult(numberA, numberB), 0.0001);
    }

    @Test
    public void shouldDivideTwoInts(){
        assertEquals(0.5, tester.divide(numberA, numberB), 0.0001);
    }
}