package com.trilogyed.ZachMerelU1Capstone.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.ZachMerelU1Capstone.dao.ConsoleDao;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
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

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleDao consoleDao;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //a List of Consoles for testing purposes
    private List<Console> consoleList;
    private List<Console> manufacturerList;

    @Before
    public void setUp() throws Exception {
        consoleList = new ArrayList<>();
        consoleList.add(new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25));
        consoleList.add(new Console(2, "PlayStation 3", "Sony", "25gb", "Sony2008", BigDecimal.valueOf(299.99), 50));
        consoleList.add(new Console(3, "PlayStation 4", "Sony", "500gb", "Sony2012", BigDecimal.valueOf(349.99), 125));
        consoleList.add(new Console(4, "Xbox One", "Microsoft", "500gb", "Microsoft2015", BigDecimal.valueOf(399.99), 25));

        manufacturerList = new ArrayList<>();
        manufacturerList.add(new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25));
        manufacturerList.add(new Console(2, "PlayStation 3", "Sony", "25gb", "Sony2008", BigDecimal.valueOf(299.99), 50));
        manufacturerList.add(new Console(3, "PlayStation 4", "Sony", "500gb", "Sony2012", BigDecimal.valueOf(349.99), 125));

        //GET ALL MOCK
        when(consoleDao.getAllConsoles()).thenReturn(consoleList);
        //GET CONSOLE BY ID MOCK
        when(consoleDao.getConsole(1)).thenReturn(consoleList.get(0));
        //CREATE/UPDATE CONSOLE MOCK?
        when(consoleDao.addConsole(consoleList.get(0))).thenReturn(consoleList.get(0));
        //GET CONSOLE BY MANUFACTURER MOCK
        when(consoleDao.getAllConsolesByManufacturer("Sony")).thenReturn(manufacturerList);


    }

    //GET ALL
    //assert
    @Test
    public void shouldReturnAllConsoles() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(consoleList);

        // act
        mockMvc
                .perform(get("/console"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //GET CONSOLE BY ID
    @Test
    public void shouldGetAConsoleById() throws  Exception {
        String outputJson = mapper.writeValueAsString(new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25));
        // act
        mockMvc
                .perform(get("/console/{id}", 1))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    //CREATE
    @Test
    public void shouldCreateANewConsole() throws Exception {
        //arrange

        String inputJson = mapper.writeValueAsString(new Console(5,"PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25));
        String outputJson = mapper.writeValueAsString(new Console(5, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25));

        // act
        mockMvc.perform(
                post("/console")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match
    }

    //DELETE
    @Test
    public void shouldDeleteARecord() throws Exception {
        //act
        mockMvc.perform(
                delete("/console/{id}", 1)
        )
                .andDo(print())
                .andExpect(status().isNoContent());          //assert

    }

    //UPDATE
    @Test
    public void shouldUpdateConsoleInfo() throws Exception {
        // arrange
        Console inputAndOutputRecordForPut = new Console(5, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(199.99), 25);
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutputRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);

        mockMvc.perform(
                put("/console/{id}", 1)     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                 // assert
                .andExpect(content().json(inputAndOutputJson));
//                .andExpect(jsonPath("$.console_id").value(3))
//                .andExpect(jsonPath("$.model").value("Playstation 2"))
//                .andExpect(jsonPath("$.manufacturer").value("Sony"))
//                .andExpect(jsonPath("$.memory_amount").value("16mb"))
//                .andExpect(jsonPath("$.processor").value("Sony2001 "))
//                .andExpect(jsonPath("$.price").value(BigDecimal.valueOf(199.99)))
//                .andExpect(jsonPath("$.quantity").value("Sony2001 "));
    }

    //GET CONSOLE BY MANUFACTURER
    @Test
    public void shouldGetConsoleByManufacturer() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(manufacturerList);

        // act
        mockMvc
                .perform(get("/console/manufacturer/{manufacturer}","Sony"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }


    }

