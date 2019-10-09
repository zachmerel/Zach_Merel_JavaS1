package com.company.recordstore.controller;

import com.company.recordstore.models.Record;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)
public class RecordStoreControllerTest {

    //Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //a List of Reocrds for testing purposes
    private List<Record> recordList;

    @Before
    public void setUp() throws Exception {
        recordList = new ArrayList<>();
        recordList.add(new Record("Eagles", "Greatest Hits", 1));
        recordList.add(new Record("Beatles", "Sgt. Peppers Lonelyhearts Club Band", 2));
        recordList.add(new Record("21 Savage", "ISSA Album", 3));
        recordList.add(new Record("Hozier", "Wasteland Baby", 4));
        // WE Don't have to set the mockMvc here because it's autowired( the @Autowired annotation aboce)
    }

    //assert
    @Test
    public void shouldReturnAllRecordsInCollection() throws Exception {
        //arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(recordList);


        //act
        mockMvc.perform(get("/records"))             //Doing a GET request
                .andDo(print())                      // We need to print the results
                .andExpect(status().isOk())          // This should be OK
                .andExpect(content().json(outputJson)); //This is what the response should be.

    }

    //assert
    @Test
    public void shouldCreateANewRecord() throws Exception {
        //arrange - parameters and the results
        String inputJson = mapper.writeValueAsString(new Record("Boyz II Men", " Cooleyhighharmony"));
        String outputJson = mapper.writeValueAsString(new Record("Boyz II Men", " Cooleyhighharmony", 5));


        //act
        mockMvc.perform(post("/records")               //Doing a POST request
                .content(inputJson)                              // set the request body
                .contentType(MediaType.APPLICATION_JSON))        //add the header (Postman helps us with this when use postman)
                .andDo(print())                                  // prints the output
                .andExpect(status().isCreated())                      // we should have gotten back a 201 - created
                .andExpect(content().json(outputJson));          //our json should match

    }

    //assert
    @Test
    public void shouldRetrieveARecord() throws Exception {
        //arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(recordList.get(3));


        //act
        mockMvc.perform(get("/records/{id}", 3)               //Doing a GET request
                .contentType(MediaType.APPLICATION_JSON))        //add the header (Postman helps us with this when use postman)
                .andDo(print())                                  // prints the output
                .andExpect(status().isOk())                      // we should have gotten back a 201 - created
                .andExpect(content().json(outputJson));          //our json should match

    }

//    assert
    @Test
    public void shouldUpdateARecord()throws Exception{
        //arrange - parameters and the results
        String inputJson = mapper.writeValueAsString(new Record("Boyz II Men", " Cooleyhighharmony",3));
        String outputJson = mapper.writeValueAsString(new Record("Boyz II Men", " Cooleyhighharmony",3));


        //act
        mockMvc.perform(put("/records/{id}", 3)//Doing a PUT request
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))        //add the header (Postman helps us with this when use postman)
                .andDo(print())                                  // prints the output
                .andExpect(status().isOk())                      // we should have gotten back a 201 - created
                .andExpect(content().json(outputJson));          //our json should match

    }

    @Test
    public void shouldDeleteARecord() throws Exception {
        //arrange - no input or output so nothing to arrange

        //act
        mockMvc.perform(delete("/records/{id}", 3))              //Doing a GET request
                .andDo(print())                                 // prints the output
                .andExpect(status().isNoContent());                      // we should have gotten back a 201 - created

        //assert
    }

}