package com.trilogyed.weatherserviceactivity.controller;

import com.trilogyed.weatherserviceactivity.models.Temperature;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeatherControllerTest {

    private Temperature temperature;

    @Before
    public void setUp() throws Exception {
        temperature = new Temperature(32,0);

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
    public void shouldGive422Status_whenZipcodeIsNotFiveDigits() throws Exception {
        // arrange
        String expectedMessage = "invalid input";

        mockMvc.perform(
                get("/condtions/{zipcode}", 123456)     // act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())                 // assert
                .andExpect(content().string(containsString(expectedMessage)));
    }

}