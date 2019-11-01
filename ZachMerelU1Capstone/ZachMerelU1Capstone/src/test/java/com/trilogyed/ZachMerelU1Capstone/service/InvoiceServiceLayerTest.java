package com.trilogyed.ZachMerelU1Capstone.service;


import com.trilogyed.ZachMerelU1Capstone.dao.*;
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

//    @Autowired
//    public InvoiceServiceLayer(ConsoleDao consoleDao, GameDao gameDao, ProcessingFeeDao processingFeeDao, TaxesDao taxesDao, TShirtDao tShirtDao) {
//        this.consoleDao = consoleDao;
//        this.gameDao = gameDao;
//        this.processingFeeDao = processingFeeDao;
//        this.taxesDao = taxesDao;
//        this.tShirtDao = tShirtDao;

    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        setUpConsoleDaoMock();
        setUpTShirtDaoMock();
        setUpTaxesDaoMock();
        setUpProcessingFeeDaoMock();
        invoiceServiceLayer = new InvoiceServiceLayer(consoleDao, gameDao, processingFeeDao, taxesDao, tShirtDao);

    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDao.class);
        Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 20);
        when(gameDao.getGame(1)).thenReturn(gameForInvoiceViewModel);

    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDao.class);
        TShirt tShirtForInvoiceViewModel = new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(20.00), 1);
        when(tShirtDao.getTShirt(1)).thenReturn(tShirtForInvoiceViewModel);

    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDao.class);
        Console consoleForInvoiceViewModel = new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(20.00), 1);
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
        Game gameForInvoiceViewModel = new Game(1, "Grand Theft Auto: Vice City", "Mature", "Grand Theft Auto: Vice City is an action-adventure video game", BigDecimal.valueOf(20.00), "Rockstar North", 20);
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
        Console consoleForInvoiceViewModel = new Console(1, "PlayStation 2", "Sony", "16mb", "Sony2001", BigDecimal.valueOf(20.00), 1);
        InputObject consoleInputObjectToInsert = new InputObject("Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", 1, 1);
        InvoiceViewModel consoleInvoiceViewModelExpected = new InvoiceViewModel(1, "Zach Merel", "Addison Ave",
                "Chicago", "IL", "60056", "Console", consoleForInvoiceViewModel,
                null, null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(20.00),
                BigDecimal.valueOf(1.00).setScale(2), BigDecimal.valueOf(14.99), BigDecimal.valueOf(35.99));
        //act
        InvoiceViewModel invoiceViewModelIGot = invoiceServiceLayer.makeAPurchase(consoleInputObjectToInsert);

        //assert
        assertEquals(invoiceViewModelIGot, consoleInvoiceViewModelExpected);
    }

    @Test
    public void shouldReturnInvoiceViewModelTypeIncludingTShirtObject_whenInputObjectIncludesItemTypeOfTShirt() {
        //arrange
        TShirt tShirtForInvoiceViewModel = new TShirt(1, "Large", "Black", "men's black tshirt", BigDecimal.valueOf(20.00), 1);
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
    public void shouldCalculateProcessingFeeGivenItemTypeAndItemQuantity() {
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
}

