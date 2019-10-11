package com.trilogyed.weatherserviceactivity.controller;

import com.trilogyed.weatherserviceactivity.models.Conditions;
import com.trilogyed.weatherserviceactivity.models.Temperature;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeatherControllerTest {

    private Temperature temperature;
    private Conditions conditions;

    @Before
    public void setUp() throws Exception {
        temperature = new Temperature(32,0);
        conditions = new Conditions(32, 0, 5, "NW", "Sunny", "none");
    }

    @Test
    public void shouldReturnTempForGivenZipcode() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(temperature);

        // act
        mockMvc.perform(get("/temp/{zipcode}", 60613))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    @Test
    public void shouldReturnTempForGivenZipcode() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(conditions);

        // act
        mockMvc.perform(get("/conditions/{zipcode}", 60613))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }


    @Test
    public void shouldGive422Status_whenZipcodeIsNotFiveDigits() throws Exception {
        // arrange
        String expectedMessage = "invalid input";

        mockMvc.perform(
                get("/conditions/{zipcode}", 123456)     // act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())                 // assert
                .andExpect(content().string(containsString(expectedMessage))));
    }

}