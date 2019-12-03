package com.trilogyed.ZachMerelU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.ZachMerelU1Capstone.exception.InvalidStateException;
import com.trilogyed.ZachMerelU1Capstone.exception.OrderTooManyException;
import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.Game;
import com.trilogyed.ZachMerelU1Capstone.model.InputObject;
import com.trilogyed.ZachMerelU1Capstone.model.TShirt;
import com.trilogyed.ZachMerelU1Capstone.service.InvoiceServiceLayer;
import com.trilogyed.ZachMerelU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceServiceLayer invoiceServiceLayer;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 20);
    private Console consoleForInvoiceViewModel = new Console(1, "Playstation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(20.00), 1);
    private TShirt tShirtForInvoiceViewModel = new TShirt(1, "Large", "Black", "mens black tshirt", BigDecimal.valueOf(20.00), 1);

    @Before
    public void setUp() throws Exception {

        //INVOICEVIEWMODEL WHEN ITEM_TYPE IS GAME
        InvoiceViewModel invoiceViewModelToReturnForGame = new InvoiceViewModel();
        invoiceViewModelToReturnForGame.setInvoice_id(1);
        invoiceViewModelToReturnForGame.setName("Zach Merel");
        invoiceViewModelToReturnForGame.setStreet("Addison Ave");
        invoiceViewModelToReturnForGame.setCity("Chicago");
        invoiceViewModelToReturnForGame.setState("IL");
        invoiceViewModelToReturnForGame.setZipcode("60056");
        invoiceViewModelToReturnForGame.setItem_type("Game");
        invoiceViewModelToReturnForGame.setConsole(null);
        invoiceViewModelToReturnForGame.settShirt(null);
        invoiceViewModelToReturnForGame.setGame(gameForInvoiceViewModel);
        invoiceViewModelToReturnForGame.setUnit_price(gameForInvoiceViewModel.getPrice());
        invoiceViewModelToReturnForGame.setSubtotal(BigDecimal.valueOf(21.00));
        invoiceViewModelToReturnForGame.setTax(BigDecimal.valueOf(1.0));
        invoiceViewModelToReturnForGame.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceViewModelToReturnForGame.setTotal(BigDecimal.valueOf(21.49));

        //INVOICEVIEWMODEL WHEN ITEM_TYPE IS GAME
        InvoiceViewModel invoiceViewModelToReturnForConsole = new InvoiceViewModel();
        invoiceViewModelToReturnForConsole.setInvoice_id(1);
        invoiceViewModelToReturnForConsole.setName("Zach Merel");
        invoiceViewModelToReturnForConsole.setStreet("Addison Ave");
        invoiceViewModelToReturnForConsole.setCity("Chicago");
        invoiceViewModelToReturnForConsole.setState("IL");
        invoiceViewModelToReturnForConsole.setZipcode("60056");
        invoiceViewModelToReturnForConsole.setItem_type("Console");
        invoiceViewModelToReturnForConsole.setConsole(consoleForInvoiceViewModel);
        invoiceViewModelToReturnForConsole.settShirt(null);
        invoiceViewModelToReturnForConsole.setGame(null);
        invoiceViewModelToReturnForConsole.setUnit_price(consoleForInvoiceViewModel.getPrice());
        invoiceViewModelToReturnForConsole.setSubtotal(BigDecimal.valueOf(21.00));
        invoiceViewModelToReturnForConsole.setTax(BigDecimal.valueOf(1.0));
        invoiceViewModelToReturnForConsole.setProcessing_fee(BigDecimal.valueOf(14.99));
        invoiceViewModelToReturnForConsole.setTotal(BigDecimal.valueOf(35.99));

        //INVOICEVIEWMODEL WHEN ITEM_TYPE IS TSHRIRT
        InvoiceViewModel invoiceViewModelToReturnForTShirt = new InvoiceViewModel();
        invoiceViewModelToReturnForTShirt.setInvoice_id(1);
        invoiceViewModelToReturnForTShirt.setName("Zach Merel");
        invoiceViewModelToReturnForTShirt.setStreet("Addison Ave");
        invoiceViewModelToReturnForTShirt.setCity("Chicago");
        invoiceViewModelToReturnForTShirt.setState("IL");
        invoiceViewModelToReturnForTShirt.setZipcode("60056");
        invoiceViewModelToReturnForTShirt.setItem_type("TShirt");
        invoiceViewModelToReturnForTShirt.setConsole(null);
        invoiceViewModelToReturnForTShirt.settShirt(tShirtForInvoiceViewModel);
        invoiceViewModelToReturnForTShirt.setGame(null);
        invoiceViewModelToReturnForTShirt.setUnit_price(tShirtForInvoiceViewModel.getPrice());
        invoiceViewModelToReturnForTShirt.setSubtotal(BigDecimal.valueOf(21.00));
        invoiceViewModelToReturnForTShirt.setTax(BigDecimal.valueOf(1.0));
        invoiceViewModelToReturnForTShirt.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoiceViewModelToReturnForTShirt.setTotal(BigDecimal.valueOf(22.98));

        //INPUT OBJECT WHEN ITEM_TYPE IS GAME
        InputObject inputGameObjectForMock = new InputObject("Zach Merel", "Addison Ave", "Chicago", "IL", "60056", "Game", 1, 1);

        //INPUT OBJECT WHEN ITEM_TYPE IS CONSOLE
        InputObject inputConsoleObjectForMock = new InputObject("Zach Merel", "Addison Ave", "Chicago", "IL", "60056", "Console", 1, 1);

        //INPUT OBJECT WHEN ITEM_TYPE IS TSHIRT
        InputObject inputTShirtObjectForMock = new InputObject("Zach Merel", "Addison Ave", "Chicago", "IL", "60056", "TShirt", 1, 1);

        //INPUT OBJECT TO THROW ORDER TOO MANY EXCEPTION
        InputObject inputTShirtObjectForMockToThrowOTMException = new InputObject("Zach Merel", "Addison Ave", "Chicago", "IL", "60056", "TShirt", 1, 100);

        //INPUT OBJECT TO THROW INVALID STATE EXCEPTION
        InputObject inputTShirtObjectForMockToThrowInvalidStateException = new InputObject("Zach Merel", "Addison Ave", "Chicago", "AA", "60056", "TShirt", 1, 1);

        //CREATE INVOICE MOCK SERVICE LAYER WHEN ITEM_TYPE IS GAME
        when(invoiceServiceLayer.makeAPurchase(inputGameObjectForMock)).thenReturn(invoiceViewModelToReturnForGame);

        //CREATE INVOICE MOCK SERVICE LAYER WHEN ITEM_TYPE IS CONSOLE
        when(invoiceServiceLayer.makeAPurchase(inputConsoleObjectForMock)).thenReturn(invoiceViewModelToReturnForConsole);

        //CREATE INVOICE MOCK SERVICE LAYER WHEN ITEM_TYPE IS TSHIRT
        when(invoiceServiceLayer.makeAPurchase(inputTShirtObjectForMock)).thenReturn(invoiceViewModelToReturnForTShirt);

        //CREATE INVOICE MOCK SERVICE LAYER WHEN THROWING ORDERTOOMANY EXCEPTION
        when(invoiceServiceLayer.makeAPurchase(inputTShirtObjectForMockToThrowOTMException))
                .thenThrow(new OrderTooManyException("Error occurred"));

        //CREATE INVOICE MOCK SERVICE LAYER WHEN THROWING INVALIDSTATE EXCEPTION
        when(invoiceServiceLayer.makeAPurchase(inputTShirtObjectForMockToThrowInvalidStateException))
                .thenThrow(new InvalidStateException("Error occurred"));

    }

    @Test
    public void shouldCreateANewInvoiceForGame() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Game", 1, 1));
        String outputJson = mapper.writeValueAsString(new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Game", null,
                null, gameForInvoiceViewModel, BigDecimal.valueOf(20.00), BigDecimal.valueOf(21.00),
                BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.49), BigDecimal.valueOf(21.49)));

        // act
        mockMvc.perform(
                post("/invoice")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match
    }

    @Test
    public void shouldCreateANewInvoiceForConsole() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", 1, 1));
        String outputJson = mapper.writeValueAsString(new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", consoleForInvoiceViewModel,
                null, null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(21.00),
                BigDecimal.valueOf(1.0), BigDecimal.valueOf(14.99), BigDecimal.valueOf(35.99)));

        // act
        mockMvc.perform(
                post("/invoice")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match
    }

    @Test
    public void shouldCreateANewInvoiceForTShirt() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "TShirt", 1, 1));
        String outputJson = mapper.writeValueAsString(new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "TShirt", null,
                tShirtForInvoiceViewModel, null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(21.00),
                BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.98), BigDecimal.valueOf(22.98)));

        // act
        mockMvc.perform(
                post("/invoice")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(outputJson));         // our json should match
    }

    @Test
    public void shouldThrowOrderTooManyException_whenTryingToCreateAnInvoiceWhereOrderQuantityExceedsInventoryQuantity() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "TShirt", 1, 100));
        //act
        mockMvc.perform(
                post("/invoice")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andExpect(status().isNotAcceptable());   //assert     // we should have gotten back a 201 - created
    }

    @Test
    public void shouldThrowInvalidStateException_whenTryingToCreateAnInvoiceWhereStateIsInvalid() throws Exception {
        //arrange
        String inputJson = mapper.writeValueAsString(new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "AA", "60056", "TShirt", 1, 1));
        //act
        mockMvc.perform(
                post("/invoice")                    //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andExpect(status().isNotFound());   //assert     // we should have gotten back a 201 - created
    }
}


