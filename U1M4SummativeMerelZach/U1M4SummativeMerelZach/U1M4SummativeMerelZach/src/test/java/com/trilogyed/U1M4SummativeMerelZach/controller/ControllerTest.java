package com.trilogyed.U1M4SummativeMerelZach.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.U1M4SummativeMerelZach.models.Answer;
import com.trilogyed.U1M4SummativeMerelZach.models.Definition;
import com.trilogyed.U1M4SummativeMerelZach.models.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldGetMagic8BallQuestionAndAnswer() throws Exception {
        // arrange
        Answer inputAndOutRecordForPut = new Answer("Will it rainng?", "It is certain.");
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        mockMvc.perform(
                post("/magic")     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())                 // assert
                //.andExpect(content().json(inputAndOutputJson));
                .andExpect(jsonPath("$.question").exists())
                .andExpect(jsonPath("$.answer").exists());
    }

    @Test
    public void shouldGetWordAndDefinition() throws Exception {
        // arrange
        Definition inputAndOutRecordForPut = new Definition("consider", "deem to be");
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        mockMvc.perform(
                get("/word")     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                 // assert
                //.andExpect(content().json(inputAndOutputJson));
                .andExpect(jsonPath("$.word").exists())
                .andExpect(jsonPath("$.definition").exists());
    }

    @Test
    public void shouldGetQuoteAndAuthor() throws Exception {
        // arrange
        Quote inputAndOutRecordForPut = new Quote("When I was your age, television was called books.", "William Goldman");
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        mockMvc.perform(
                get("/quote")     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                 // assert
                //.andExpect(content().json(inputAndOutputJson));
                .andExpect(jsonPath("$.quote").exists())
                .andExpect(jsonPath("$.author").exists());
    }

    @Test
    public void shouldGive422Status_WhenUserDoesNotAskQuestionFor8Ball() throws Exception {
        // build parameters and expected output if necessary...
        // arrange
        Answer badAnswer = new Answer("");
        String inputJson = mapper.writeValueAsString(badAnswer);
        String expectedMessage = "You must enter a question.";

        //        // act
        mockMvc.perform(
                post("/magic")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString(expectedMessage)));

    }

    @Test
    public void shouldReturnSameQuestionAsAskedWithRandomAnswer() throws Exception {
        // arrange
        String inputJson = mapper.writeValueAsString(new Answer("Will it rain?","It is certain"));



        // act
        mockMvc.perform(
                post("/magic")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(jsonPath("$.answer").exists())
                .andExpect(jsonPath("$.question").value("Will it rain?"));
    }



}