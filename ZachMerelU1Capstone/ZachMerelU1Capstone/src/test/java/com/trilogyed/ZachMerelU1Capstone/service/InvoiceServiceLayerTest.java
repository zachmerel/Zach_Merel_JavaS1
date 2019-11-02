package com.trilogyed.ZachMerelU1Capstone.service;


import com.trilogyed.ZachMerelU1Capstone.dao.*;
import com.trilogyed.ZachMerelU1Capstone.exception.InvalidStateException;
import com.trilogyed.ZachMerelU1Capstone.exception.OrderToManyException;
import com.trilogyed.ZachMerelU1Capstone.model.*;
import com.trilogyed.ZachMerelU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceServiceLayerTest {

    private InvoiceServiceLayer invoiceServiceLayer;
    private TaxesDao taxesDao;
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private ProcessingFeeDao processingFeeDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;


    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        setUpConsoleDaoMock();
        setUpTShirtDaoMock();
        setUpTaxesDaoMock();
        setUpProcessingFeeDaoMock();
        setUpInvoiceDao();
        invoiceServiceLayer = new InvoiceServiceLayer(consoleDao, gameDao, processingFeeDao, taxesDao, tShirtDao, invoiceDao);

    }

    public void setUpInvoiceDao() {
        invoiceDao = mock(InvoiceDao.class);
        Invoice invoiceIexpect = new Invoice();
        invoiceIexpect.setId(1);
        invoiceIexpect.setName("Zach Merel");
        invoiceIexpect.setStreet("Addison Ave");
        invoiceIexpect.setCity("Chicago");
        invoiceIexpect.setZipcode("60613");
        invoiceIexpect.setItem_type("Game");
        invoiceIexpect.setItem_id(1);
        invoiceIexpect.setQuantity(1);
        invoiceIexpect.setUnit_price(BigDecimal.valueOf(20.00));
        invoiceIexpect.setSubtotal(BigDecimal.valueOf(20.00));
        invoiceIexpect.setTax(BigDecimal.valueOf(1.00));
        invoiceIexpect.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceIexpect.setTotal(BigDecimal.valueOf(22.49));

        Invoice invoiceToAdd = new Invoice();
        invoiceIexpect.setName("Zach Merel");
        invoiceIexpect.setStreet("Addison Ave");
        invoiceIexpect.setCity("Chicago");
        invoiceIexpect.setZipcode("60613");
        invoiceIexpect.setItem_type("Game");
        invoiceIexpect.setItem_id(1);
        invoiceIexpect.setQuantity(1);
        invoiceIexpect.setUnit_price(BigDecimal.valueOf(20.00));
        invoiceIexpect.setSubtotal(BigDecimal.valueOf(20.00));
        invoiceIexpect.setTax(BigDecimal.valueOf(1.00));
        invoiceIexpect.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceIexpect.setTotal(BigDecimal.valueOf(22.49));

        when(invoiceDao.addInvoice(invoiceToAdd)).thenReturn(invoiceIexpect);
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDao.class);
        Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 5);
        Game gameForThrowingException = new Game(2, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 1);


        when(gameDao.getGame(1)).thenReturn(gameForInvoiceViewModel);
        when(gameDao.getGame(2))
                .thenThrow(new OrderToManyException("Error occurred"));
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDao.class);
        TShirt tShirtForInvoiceViewModel = new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(20.00), 5);
        when(tShirtDao.getTShirt(1)).thenReturn(tShirtForInvoiceViewModel);

    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDao.class);
        Console consoleForInvoiceViewModel = new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(20.00), 5);
        when(consoleDao.getConsole(1)).thenReturn(consoleForInvoiceViewModel);
    }

    private void setUpTaxesDaoMock() {
        taxesDao = mock(TaxesDao.class);
        StateTaxRate stateTaxRate1 = new StateTaxRate();
        stateTaxRate1.setState("IL");
        stateTaxRate1.setRate(BigDecimal.valueOf(0.05));

        StateTaxRate stateTaxRate2 = new StateTaxRate();
        stateTaxRate2.setState("VT");
        stateTaxRate2.setRate(BigDecimal.valueOf(0.07));

        doReturn(stateTaxRate1).when(taxesDao).getTaxRate("IL");
        doReturn(stateTaxRate2).when(taxesDao).getTaxRate("VT");
        when(taxesDao.getTaxRate("AA"))
                .thenThrow(new InvalidStateException("Error occurred"));


    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDao.class);
        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProduct_type("Game");
        processingFee1.setFee(BigDecimal.valueOf(1.49));

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProduct_type("TShirt");
        processingFee2.setFee(BigDecimal.valueOf(1.98));

        ProcessingFee processingFee3 = new ProcessingFee();
        processingFee3.setProduct_type("Console");
        processingFee3.setFee(BigDecimal.valueOf(14.99));

        doReturn(processingFee1).when(processingFeeDao).getProcessingFee("Game");
        doReturn(processingFee2).when(processingFeeDao).getProcessingFee("TShirt");
        doReturn(processingFee3).when(processingFeeDao).getProcessingFee("Console");

    }

    @Test
    public void shouldReturnInvoiceViewModelTypeIncludingGameObject_whenInputObjectIncludesItemTypeOfGame() {
        //arrange
        Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 5);
        InputObject gameInputObjectToInsert = new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Game", 1, 1);
        InvoiceViewModel gameInvoiceViewModelExpected = new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Game", null,
                null, gameForInvoiceViewModel, BigDecimal.valueOf(20.00), BigDecimal.valueOf(20.00),
                BigDecimal.valueOf(1.00).setScale(2), BigDecimal.valueOf(1.49), BigDecimal.valueOf(22.49));
        //act
        InvoiceViewModel invoiceViewModelIGot = invoiceServiceLayer.makeAPurchase(gameInputObjectToInsert);

        //assert
        assertEquals(gameInvoiceViewModelExpected, invoiceViewModelIGot);
    }

    @Test
    public void shouldReturnInvoiceViewModelTypeIncludingConsoleObject_whenInputObjectIncludesItemTypeOfConsole() {
        //arrange
        Console consoleForInvoiceViewModel = new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(20.00), 5);
        InputObject consoleInputObjectToInsert = new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", 1, 5);
        InvoiceViewModel consoleInvoiceViewModelExpected = new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", consoleForInvoiceViewModel,
                null, null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(100.00),
                BigDecimal.valueOf(5.00).setScale(2), BigDecimal.valueOf(14.99), BigDecimal.valueOf(119.99));
        //act
        InvoiceViewModel invoiceViewModelIGot = invoiceServiceLayer.makeAPurchase(consoleInputObjectToInsert);

        //assert
        assertEquals(invoiceViewModelIGot, consoleInvoiceViewModelExpected);
    }

    @Test
    public void shouldReturnInvoiceViewModelTypeIncludingTShirtObject_whenInputObjectIncludesItemTypeOfTShirt() {
        //arrange
        TShirt tShirtForInvoiceViewModel = new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(20.00), 5);
        InputObject tShirtInputObjectToInsert = new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "TShirt", 1, 1);
        InvoiceViewModel consoleInvoiceViewModelExpected = new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "TShirt", null,
                tShirtForInvoiceViewModel, null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(20.00),
                BigDecimal.valueOf(1.00).setScale(2), BigDecimal.valueOf(1.98), BigDecimal.valueOf(22.98));
        //act
        InvoiceViewModel invoiceViewModelIGot = invoiceServiceLayer.makeAPurchase(tShirtInputObjectToInsert);

        //assert
        assertEquals(invoiceViewModelIGot, consoleInvoiceViewModelExpected);
    }


    @Test
    public void shouldCalculateSalesTaxGivenStateAndTotalCost() {
        //arrange

        StateTaxRate stateTaxRateIExpect = new StateTaxRate();
        stateTaxRateIExpect.setRate(BigDecimal.valueOf(.05));
        stateTaxRateIExpect.setState("IL");

        BigDecimal salesTaxIExpect = (BigDecimal.valueOf(1.00)).setScale(2);

        //act
        BigDecimal salesTaxIGot = invoiceServiceLayer.calculateSalesTax(stateTaxRateIExpect.getState(), BigDecimal.valueOf(20.00));

        //assert
        assertEquals(salesTaxIGot, salesTaxIExpect);
    }

    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForLessThanOrEqualTenTGames() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFee.setProduct_type("Game");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(1.49);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 1);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }

    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForLessThanOrEqualTenTShirts() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.98));
        processingFee.setProduct_type("TShirt");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(1.98);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 1);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }

    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForLessThanOrEqualTenConsoles() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFee.setProduct_type("Console");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(14.99);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 1);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }

    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForOverTenGames() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFee.setProduct_type("Game");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(16.98);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 11);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }

    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForOverTenConsoles() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFee.setProduct_type("Console");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(30.48);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 11);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }


    @Test
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantityForOverTenTShirts() {
        //arrange
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.98));
        processingFee.setProduct_type("TShirt");

        BigDecimal processingFeeIExpect = BigDecimal.valueOf(17.47);

        //act
        BigDecimal processingFeeIGot = invoiceServiceLayer.calculateProcessingFee(processingFee.getProduct_type(), 11);

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);
    }

    @Test
    public void shouldUpdateItemInventoryQuantityForGame() {
        //arrange
        int numberOfItemsInStock = 5;
        int numberOfItemsInOrder = 3;

        int numberOfItemsIExpectToBeInStock = 2;

        //act
        int numberOfItemsIGotBackFromItemQuantity = invoiceServiceLayer.updateInventoryQuantity(3, 1, "Game");

        //assert
        assertEquals(numberOfItemsIExpectToBeInStock, numberOfItemsIGotBackFromItemQuantity);
    }

    @Test
    public void shouldUpdateItemInventoryQuantityForConsole() {
        //arrange
        int numberOfItemsInStock = 5;
        int numberOfItemsInOrder = 3;

        int numberOfItemsIExpectToBeInStock = 2;

        //act
        int numberOfItemsIGotBackFromItemQuantity = invoiceServiceLayer.updateInventoryQuantity(3, 1, "Console");

        //assert
        assertEquals(numberOfItemsIExpectToBeInStock, numberOfItemsIGotBackFromItemQuantity);
    }

    @Test
    public void shouldUpdateItemInventoryQuantityForTShirt() {
        //arrange
        int numberOfItemsInStock = 5;
        int numberOfItemsInOrder = 3;

        int numberOfItemsIExpectToBeInStock = 2;

        //act
        int numberOfItemsIGotBackFromItemQuantity = invoiceServiceLayer.updateInventoryQuantity(3, 1, "TShirt");

        //assert
        assertEquals(numberOfItemsIExpectToBeInStock, numberOfItemsIGotBackFromItemQuantity);
    }

    @Test
    public void shouldEnsureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHandForGame() {
        //arrange
        boolean whatIExpect = true;

        //act
        boolean itemOrderCountLessInventory = invoiceServiceLayer.ensureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHand(3, "Game", 1);

        //assert
        //SAME THING
        assertEquals(whatIExpect, itemOrderCountLessInventory);
//        assertTrue(itemOrderCountLessInventory);
    }

    @Test
    public void shouldEnsureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHandForConsole() {
        //arrange
        boolean whatIExpect = true;

        //act
        boolean itemOrderCountLessInventory = invoiceServiceLayer.ensureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHand(3, "Console", 1);

        //assert
        //SAME THING
        assertEquals(whatIExpect, itemOrderCountLessInventory);
//        assertTrue(itemOrderCountLessInventory);
    }

    @Test
    public void shouldEnsureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHandForTShirt() {
        //arrange
        boolean whatIExpect = true;

        //act
        boolean itemOrderCountLessInventory = invoiceServiceLayer.ensureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHand(3, "TShirt", 1);

        //assert
        //SAME THING
        assertEquals(whatIExpect, itemOrderCountLessInventory);
//        assertTrue(itemOrderCountLessInventory);
    }

    @Test
    public void shouldCheckToEnsureThatStateCodeIsValid() {
        //arrange
        boolean whatIExpect = true;

        //act
        boolean stateCodeIsValid = invoiceServiceLayer.checkForStateCode("IL");

        //assert
        assertEquals(whatIExpect, stateCodeIsValid);
    }

    @Test(expected = InvalidStateException.class)
    public void shouldCheckToEnsureThatStateCodeIsNotValid() {
        //arrange
//        boolean whatIExpect = false;

        //act
//        boolean stateCodeIsValid = invoiceServiceLayer.checkForStateCode("AA");
        invoiceServiceLayer.checkForStateCode("AA");

        //assert
//        assertEquals(whatIExpect, stateCodeIsValid);
    }
//
//    @Test
//    public void shouldGive406Status_whenOrderQuantityExceedsOrderInventory() throws Exception {
//        // arrange
//
//    }

    @Test(expected = OrderToManyException.class)
    public void whenEnsureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHandNotTrue_thenExpectToThrowOrderToManyException() {

        //act
        invoiceServiceLayer.ensureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHand(7, "Game", 2);


    }

    @Test
    public void shouldAddInvoiceWithObjectGameToDataBase() {
//        Game gameForInvoice = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 5);
        //arrange
        Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 5);

        InvoiceViewModel invoiceViewModelToInsert = new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Game", null,
                null, gameForInvoiceViewModel, BigDecimal.valueOf(20.00), BigDecimal.valueOf(20.00),
                BigDecimal.valueOf(1.00).setScale(2), BigDecimal.valueOf(1.49), BigDecimal.valueOf(22.49));

        Invoice invoiceIexpect = new Invoice();
        invoiceIexpect.setId(1);
        invoiceIexpect.setName("Zach Merel");
        invoiceIexpect.setStreet("Addison Ave");
        invoiceIexpect.setCity("Chicago");
        invoiceIexpect.setZipcode("60613");
        invoiceIexpect.setItem_type("Game");
        invoiceIexpect.setItem_id(1);
        invoiceIexpect.setQuantity(1);
        invoiceIexpect.setUnit_price(BigDecimal.valueOf(20.00));
        invoiceIexpect.setSubtotal(BigDecimal.valueOf(20.00));
        invoiceIexpect.setTax(BigDecimal.valueOf(1.00));
        invoiceIexpect.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceIexpect.setTotal(BigDecimal.valueOf(22.49));

        //act
        Invoice invoiceToSave = invoiceServiceLayer.saveInvoice(invoiceViewModelToInsert);

        //assert
        assertEquals(invoiceIexpect, invoiceToSave);
    }
}

