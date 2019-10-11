package com.trilogyed.monthconverter.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthConverterController.class)
public class MonthConverterControllerTest {


    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MonthConverterController mcc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnAMonthNameAccordingToTheGivenNumber() throws Exception {
        // arrange - parameters and the results
        int myInput = 1;
        String myDesiredOutput = "January";

        // act
        mockMvc.perform(get("/day/{monthNumber}", myInput))        // Doing a GET request
                .andDo(print())                             // We need to print the results
                .andExpect(status().isOk())    //assert     // This should be OK
                //.andExpect(content().json(outputJson));     // this is what the response should be.
                .andExpect(content().string(myDesiredOutput));

    }

    @Test
    public void shouldReturn418() throws Exception {
        int input = 13;

        mockMvc.perform(get("/day/{monthNumber}", input))
                .andDo(print())
                .andExpect(status().isIAmATeapot())
                .andExpect(content().string(containsString("invalid input")));
    }

    @Test
    public void shouldGetTheNameOfAMonth() {
        // arrange
        //input - int
        int myInput = 1;
        String myDesiredOutput = "January";

        // act

        // assert
        assertEquals(myDesiredOutput, mcc.translateIntegerToMonthName(myInput));
    }

}