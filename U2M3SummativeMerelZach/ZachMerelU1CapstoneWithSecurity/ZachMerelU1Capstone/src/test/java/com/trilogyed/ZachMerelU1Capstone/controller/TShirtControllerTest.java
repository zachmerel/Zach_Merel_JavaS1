package com.trilogyed.ZachMerelU1Capstone.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.ZachMerelU1Capstone.model.TShirt;
import com.trilogyed.ZachMerelU1Capstone.service.InvoiceServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceServiceLayer invoiceServiceLayer;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //a List of Consoles for testing purposes
    private List<TShirt> tShirtList;
    private List<TShirt> tShirtSizeList;
    private List<TShirt> tShirtColorList;

    @Before
    public void setUp() throws Exception {
        tShirtList = new ArrayList<>();
        tShirtList.add(new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        tShirtList.add(new TShirt(2, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        tShirtList.add(new TShirt(3, "Medium", "Blue", "men's blue tshirt", BigDecimal.valueOf(8.99), 25));

        tShirtSizeList = new ArrayList<>();
        tShirtSizeList.add(new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        tShirtSizeList.add(new TShirt(2, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));

        tShirtColorList = new ArrayList<>();
        tShirtColorList.add(new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        tShirtColorList.add(new TShirt(2, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));

        TShirt createMockTShirtObject = new TShirt("Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25);

        //GET ALL MOCK
        when(invoiceServiceLayer.getAllTShirts()).thenReturn(tShirtList);
        //GET TSHIRT BY ID MOCK
        when(invoiceServiceLayer.getTShirt(1)).thenReturn(tShirtList.get(0));
        //CREATE TSHIRT MOCK
        when(invoiceServiceLayer.addTShirt(createMockTShirtObject)).thenReturn(tShirtList.get(0));
        //GET TSHIRT BY SIZE MOCK
        when(invoiceServiceLayer.getAllTShirtsBySize("Large")).thenReturn(tShirtSizeList);
        //GET TSHIRT BY COLOR MOCK
        when(invoiceServiceLayer.getAllTShirtsByColor("Black")).thenReturn(tShirtColorList);
        //UPDATE CONSOLE RETURNS VOID SO NO MOCK POSSIBLE

    }

    //GET ALL
    //assert
    @Test
    public void shouldReturnAllTshirts() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(tShirtList);

        // act
        mockMvc
                .perform(get("/tshirt"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //GET BY ID
    @Test
    public void shouldGetATShirtById() throws Exception {
        String outputJson = mapper.writeValueAsString(new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        // act
        mockMvc
                .perform(get("/tshirt/{id}", 1))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //DELETE
    @Test
    public void shouldDeleteATshirt() throws Exception {
        //act
        mockMvc.perform(
                delete("/tshirt/{id}", 1)
        )
                .andDo(print())
                .andExpect(status().isNoContent());          //assert

    }

    //UPDATE
    @Test
    public void shouldUpdateATshirt() throws Exception {
        // arrange
        TShirt inputTShirtForPut = new TShirt(1, "X-Large", "Red", "men's red tshirt", BigDecimal.valueOf(8.99), 25);
        String inputJson = mapper.writeValueAsString(inputTShirtForPut);

        mockMvc.perform(
                put("/tshirt/{id}", 1)     // act
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());                 // assert

    }

    //CREATE
    @Test
    public void shouldCreateATShirt() throws Exception {
        //arrange

        String inputJson = mapper.writeValueAsString(new TShirt("Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));
        String outputJson = mapper.writeValueAsString(new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(8.99), 25));

        // act
        mockMvc.perform(
                post("/tshirt")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match


    }

    //GET TSHIRT BY SIZE
    @Test
    public void shouldGetTShirtBySize() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(tShirtSizeList);

        // act
        mockMvc
                .perform(get("/tshirt/size/{size}", "Large"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //GET TSHIRT BY COLOR
    @Test
    public void shouldGetTShirtByColor() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(tShirtColorList);

        // act
        mockMvc
                .perform(get("/tshirt/color/{color}", "Black"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

}
