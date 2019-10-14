package com.trilogyed.cityserviceactivity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.cityserviceactivity.models.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // a List of Records for testing purposes
    private List<City> cityList;

    @Before
    public void setUp() throws Exception {
        cityList = new ArrayList<City>();
        cityList.add(new City("Chicago","Illinois", 2716000,false));
        cityList.add(new City("Indianapolis", "Indiana",852506,true ));
        cityList.add(new City("Boston", "Massachusetts", 645996,true ));

    }

    @Test
    public void shouldReturnAllCitiesInCollection() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(cityList);

        // act
        mockMvc.perform(get("/city"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    @Test
    public void shouldCityInCollectionWithGivenName() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(new City("Chicago","Illinois", 2716000,false));

        // act
        mockMvc.perform(get("/city/{name}","Chicago"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    @Test
    public void shouldCreateANewCity() throws Exception {
        // arrange
        String inputJson = mapper.writeValueAsString(new City("New York City", "New York", 8623000, false ));
        String outputJson = mapper.writeValueAsString(new City("New York City", "New York", 8623000, false ));

        // act
        mockMvc.perform(
                post("/city")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().json(outputJson));         // our json should match
    }

    @Test
    public void shouldDeleteACity() throws Exception {
        //arrange - no input or output. so, nothing to arrange!

        //act
        mockMvc.perform(
                delete("/city/{name}", "Chicago")
        )
                .andDo(print())
                .andExpect(status().isNoContent());          //assert
    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidCity() throws Exception {
        // build parameters and expected output if necessary...
        // arrange
        String inputJson = mapper.writeValueAsString(new City("", "New York", 8623000, false ));
        String expectedMessage = "You must supply a value for name.";

        //        // act
        mockMvc.perform(
                post("/city")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString(expectedMessage)));

    }




}