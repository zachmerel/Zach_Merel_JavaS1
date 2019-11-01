package com.trilogyed.ZachMerelU1Capstone.service;

import com.trilogyed.ZachMerelU1Capstone.dao.*;
import com.trilogyed.ZachMerelU1Capstone.model.*;
import com.trilogyed.ZachMerelU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class InvoiceServiceLayer {


    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private ProcessingFeeDao processingFeeDao;
    private TaxesDao taxesDao;
    private TShirtDao tShirtDao;

    @Autowired
    public InvoiceServiceLayer(ConsoleDao consoleDao, GameDao gameDao, ProcessingFeeDao processingFeeDao, TaxesDao taxesDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.processingFeeDao = processingFeeDao;
        this.taxesDao = taxesDao;
        this.tShirtDao = tShirtDao;
    }
//===============================================================================
    // in the ACTUAL SERVICE LAYER
//    public InvoiceViewModel makeAPurchase(InputObject inputObject) {
//        InvoiceVIewModel returnVal = new InvoiceViewModel();
//        if (inputObject.getType().equals("game")) {
//            // get the game from the dao
//        } else if (inputObject.getType().equals("console")) {
//            //get the console from the dao
//        } else {
//            // get the tshirt from the dao
//        }
//        // figure out how to get the state
//        // figure out how to get the total cost
//        returnVal.setTax(calculateTax(inputObject.getState(), /* total cost*/));
//        // figure out the inputs for the processing fee
//        returnVal.setProcessingFee(calculateProcessingFee(...));
//    }
//===============================================================================================


    public InvoiceViewModel makeAPurchase(InputObject inputObject) {

        InvoiceViewModel returnVal = new InvoiceViewModel();
        //REMOVE THIS WHEN ADDING TO DATABASE INSTEAD OF USING MOCK
        returnVal.setInvoice_id(1);
        returnVal.setName(inputObject.getName());
        returnVal.setStreet(inputObject.getStreet());
        returnVal.setCity(inputObject.getCity());
        returnVal.setState(inputObject.getState());
        returnVal.setZipcode(inputObject.getZipcode());
        returnVal.setItem_type(inputObject.getItem_type());
//        returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(),inputObject.getQuantity()));

        BigDecimal unitPrice;
        if (inputObject.getItem_type().equalsIgnoreCase("Game")) {
            returnVal.setGame(gameDao.getGame(inputObject.getItem_id()));
            returnVal.setConsole(null);
            returnVal.settShirt(null);
            Game game = gameDao.getGame(inputObject.getItem_id());
            unitPrice = game.getPrice();
            returnVal.setUnit_price(unitPrice);
            returnVal.setSubtotal(unitPrice.multiply(new BigDecimal(inputObject.getQuantity())));
            returnVal.setTax(calculateSalesTax(inputObject.getState(), returnVal.getSubtotal()));
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(),inputObject.getQuantity()));
            returnVal.setTotal(returnVal.getTax().add((returnVal.getSubtotal().add(returnVal.getProcessing_fee()))));
        } else if (inputObject.getItem_type().equalsIgnoreCase("Console")) {
            returnVal.setConsole(consoleDao.getConsole(inputObject.getItem_id()));
            returnVal.setGame(null);
            returnVal.settShirt(null);
            Console console = consoleDao.getConsole(inputObject.getItem_id());
            unitPrice = console.getPrice();
            returnVal.setUnit_price(unitPrice);
            returnVal.setSubtotal(unitPrice.multiply(new BigDecimal(inputObject.getQuantity())));
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(),inputObject.getQuantity()));
            returnVal.setTax(calculateSalesTax(inputObject.getState(), returnVal.getSubtotal()));

            returnVal.setTotal(returnVal.getTax().add((returnVal.getSubtotal().add(returnVal.getProcessing_fee()))));
        } else {
            returnVal.settShirt(tShirtDao.getTShirt(inputObject.getItem_id()));
            returnVal.setGame(null);
            returnVal.setConsole(null);
            TShirt tShirt = tShirtDao.getTShirt(inputObject.getItem_id());
            unitPrice = tShirt.getPrice();
            returnVal.setUnit_price(unitPrice);
            returnVal.setSubtotal(unitPrice.multiply(new BigDecimal(inputObject.getQuantity())));
            returnVal.setTax(calculateSalesTax(inputObject.getState(), returnVal.getSubtotal()));
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(),inputObject.getQuantity()));
            returnVal.setTotal(returnVal.getTax().add((returnVal.getSubtotal().add(returnVal.getProcessing_fee()))));
        }


//        Sales tax applies only to the cost of the items.
//        Sales tax does not apply to any processing fees for an invoice.
//        The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an additional processing fee of $15.49 is applied to the order.
//        The order process logic must properly update the quantity on hand for the item in the order.
//        Order quantity must be greater than zero.
//        Order quantity must be less than or equal to the number of items on hand in inventory.
//        Order must contain a valid state code.
//        The REST API must properly handle and report all violations of business rules.
        return returnVal;
    }

    //CALCULATE SALES TAX(1-2)
    public BigDecimal calculateSalesTax(String state, BigDecimal subtotal) {
        StateTaxRate stateTaxRate = taxesDao.getTaxRate(state);
        BigDecimal rate = stateTaxRate.getRate();
        return (subtotal.multiply(rate)).setScale(2, RoundingMode.HALF_DOWN);


    }

    //
    //CALCULATE PROCESSING FEE(3)
    public BigDecimal calculateProcessingFee(String product_type, int quantity) {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(product_type);
        BigDecimal fee = processingFee.getFee();
        BigDecimal additionProcessingFee = new BigDecimal(15.49);
        if(quantity > 10){
            return (additionProcessingFee.add(fee)).setScale(2, RoundingMode.HALF_DOWN);
        }else{
            return fee;
        }

    }

    //UPDATES THE QUANTITY OF ITEM(4)
//    public void updateOrderQuantity(){
//
//    }

    //ENSURES ORDER QUANTITY IS GREATER THAN 0 (5)
//    public boolean ensureOrderQuantityIsGreaterThanZero(){
//
//    }

    //ORDER QUANTITY GREAT THAN OR EQUAL NUMBER OF INVENTORY ON HAND(6)
//    public void ensureOrderQuantityGreaterThanNumberOfInventoryOnHand() {
//
//    }

    //CHECK FOR VALID STATE CODE(7)
//    public boolean checkForStateCode(){
//        return
//    }

//    @Transactional
//    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){
//        Invoice invoice = new Invoice();
//        invoice.setName(invoiceViewModel.getName());
//        invoice.setStreet(invoiceViewModel.getStreet());
//        invoice.setCity(invoiceViewModel.getCity());
//        invoice.setZipcode(invoiceViewModel.getZipcode());
//        invoice.setItem_type(invoiceViewModel.getItem_type());
//        //NEED GAME/CONSOLE/TSHIRT HERE?
//
//
//    }

    //
    //Console API
    //
//    public Console addConsole(Console console) {
//        return consoleDao.addConsole(console);
//    }
//
//    public Console getConsole(int id) {
//        return consoleDao.getConsole(id);
//    }
//
//    public List<Console> getAllConsoles() {
//        return consoleDao.getAllConsoles();
//    }
//
//    public List<Console> getAllConsolesByManufacturer(String manufacturer) {
//        return consoleDao.getAllConsolesByManufacturer(manufacturer);
//    }
//
//    public void updateConsole(Console console) {
//        consoleDao.updateConsole(console);
//    }
//
//    public void deleteConsole(int id) {
//        consoleDao.deleteConsole(id);
//    }
//    //
//    // Game API
//    //
//
//    public Game addGame(Game game) {
//        return gameDao.addGame(game);
//    }
//
//    public Game getGame(int id) {
//        return gameDao.getGame(id);
//    }
//
//    public List<Game> getAllGames() {
//        return gameDao.getAllGames();
//    }
//
//    public List<Game> getAllGamesByStudio(String studio) {
//        return gameDao.getAllGamesByStudio(studio);
//    }
//
//    public List<Game> getAllGamesByEsrbRating(String esrb_rating) {
//        return gameDao.getAllGamesByEsrbRating(esrb_rating);
//    }
//
//    public List<Game> getAllGamesByTitle(String title) {
//        return gameDao.getAllGamesByTitle(title);
//    }
//
//    public void updateGame(Game game) {
//        gameDao.updateGame(game);
//    }
//
//    public void deleteGame(int id) {
//        gameDao.deleteGame(id);
//    }
//
//    //
//    // TSHIRT API
//    //
//
//    public TShirt addTShirt(TShirt tShirt) {
//        return tShirtDao.addTShirt(tShirt);
//    }
//
//    public TShirt getTShirt(int id) {
//        return tShirtDao.getTShirt(id);
//    }
//
//    public List<TShirt> getAllTShirts() {
//        return tShirtDao.getAllTShirts();
//    }
//
//    public List<TShirt> getAllTShirtsByColor(String color) {
//        return tShirtDao.getAllTShirtsByColor(color);
//    }
//
//    public List<TShirt> getAllTShirtsBySize(String size) {
//        return tShirtDao.getAllTShirtsBySize(size);
//    }
//
//    public void updateTShirt(TShirt tShirt) {
//        tShirtDao.updateTShirt(tShirt);
//    }
//
//    public void deleteTShirt(int id) {
//        tShirtDao.deleteTShirt(id);
//    }
//    //
//    // PROCESSING FEE API
//    //
//
//    public ProcessingFee getProcessingFee(String product_type) {
//        return processingFeeDao.getProcessingFee(product_type);
//    }
//    //
//    //SALES TAX RATE API
//    //
//
//    public StateTaxRate getTaxRate(String state) {
//        return taxesDao.getTaxRate(state);
//    }
//
//
//    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
//
//
//        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
//        invoiceViewModel.setInvoice_id(invoice.getId());
//        invoiceViewModel.setName(invoice.getName());
//        invoiceViewModel.setStreet(invoice.getStreet());
//        invoiceViewModel.setCity(invoice.getCity());
//        invoiceViewModel.setState(invoice.getState());
//        invoiceViewModel.setZipcode(invoice.getZipcode());
//        invoiceViewModel.setItem_type(invoice.getItem_type());
//        invoiceViewModel.setUnit_price(invoice.getUnit_price());
//        invoiceViewModel.setSubtotal(invoice.getSubtotal());
//        invoiceViewModel.setTax(invoice.getTax());
//        invoiceViewModel.setProcessing_fee(invoice.getProcessing_fee());
//        invoiceViewModel.setTotal(invoice.getTotal());
//
//        Console console = consoleDao.getConsole(invoice.getConsoleId());
//        invoiceViewModel.setConsoleId(console.getConsole_id());
//
//        Game game = gameDao.getGame(invoice.getGameId());
//        invoiceViewModel.setGameId(game.getGame_id());
//
//        TShirt tShirt = tShirtDao.getTShirt(invoice.gettShirtId());
//        invoiceViewModel.settShirtId(tShirt.getT_shirt_id());
//
//        return invoiceViewModel;
//    }
}
