package com.trilogyed.weatherserviceactivity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.weatherserviceactivity.models.Conditions;
import com.trilogyed.weatherserviceactivity.models.Temperature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

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
    public void shouldReturnConditionsForGivenZipcode() throws Exception {
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
                get("/conditions/{zipcode}", 123456) )    // act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())                 // assert
                .andExpect(content().string(containsString(expectedMessage)));
    }

}