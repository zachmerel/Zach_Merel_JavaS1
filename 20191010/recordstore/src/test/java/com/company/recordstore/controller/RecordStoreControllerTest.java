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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)
public class RecordStoreControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // a List of Records for testing purposes
    private List<Record> recordList;

    @Before
    public void setUp() throws Exception {
        recordList = new ArrayList<Record>();
        recordList.add(new Record("Eagles", "Greatest Hits", "1973", 1));
        recordList.add(new Record("Beatles", "Sgt. Peppers Lonelyhearts Club Band", "1969", 2));
        recordList.add(new Record("21 Savage", "ISSA Album", "2018", 3));
        recordList.add(new Record("Hozier", "Wasteland Baby", "2017", 4));

        // We don't have to set the mockMvc here because it's autowired (the @Autowired annotation above)
    }

    //assert
    @Test
    public void shouldReturnAllRecordsInCollection() throws Exception {
        // arrange - parameters and the results
        String outputJson = mapper.writeValueAsString(recordList);

        // act
        mockMvc.perform(get("/records"))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                .andExpect(content().json(outputJson));     // this is what the response should be.

    }

    @Test
    public void shouldCreateANewRecord() throws Exception {
        // arrange
        String inputJson = mapper.writeValueAsString(new Record("Boyz II Men", "Cooleyhighharmony", "1991"));
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
    public void shouldDeleteARecord() throws Exception {
        //arrange - no input or output. so, nothing to arrange!

        //act
        mockMvc.perform(
                delete("/records/{id}", 4)
        )
                .andDo(print())
                .andExpect(status().isNoContent());          //assert
    }

    @Test
    public void shouldUpdateRecordInfo() throws Exception {
        // arrange
        Record inputAndOutRecordForPut = new Record("The Beatles", "Abbey Road", "1967", 2);
        String inputAndOutputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);

        mockMvc.perform(
                put("/records/{id}", 2)     // act
                        .content(inputAndOutputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                 // assert
                .andExpect(content().json(inputAndOutputJson));
    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidRecord() throws Exception {
        // build parameters and expected output if necessary...
        // arrange
        String inputJson = mapper.writeValueAsString(new Record("", "Cooleyhighharmony", "1991"));
        String expectedMessage = "You MUST supply a value for artist.  ;)";

        //        // act
        mockMvc.perform(
                post("/records")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString(expectedMessage)));

    }

    @Test
    public void shouldGive422Status_whenIdInPathDoesNotMatchIdInRequestBody() throws Exception {
        // arrange
        Record inputAndOutRecordForPut = new Record("The Beatles", "Abbey Road", "1967", 2);
        String inputJson = mapper.writeValueAsString(inputAndOutRecordForPut);
        String expectedMessage = "The id in the path does not equal the id in the request body";
        //String outputJson = mapper.writeValueAsString(inputAndOutRecordForPut);

        mockMvc.perform(
                put("/records/{id}", 3)     // act
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())                 // assert
                .andExpect(content().string(containsString(expectedMessage)));
    }

    @Test
    public void shouldGive404Status_whenIdInPathDoesNotMatchIdInRecordList() throws Exception {
        // arrange - parameters and the results
        String inputJson = mapper.writeValueAsString(100);
        String expectedMessage = "This id does not correspond to a record";

        // act
        mockMvc.perform(get("/records/{id}",100))
                // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isNotFound())                 // assert
                .andExpect(content().string(containsString(expectedMessage)));

    }

}