package com.trilogyed.ZachMerelU1Capstone.service;

import com.trilogyed.ZachMerelU1Capstone.dao.*;
import com.trilogyed.ZachMerelU1Capstone.exception.InvalidStateException;
import com.trilogyed.ZachMerelU1Capstone.exception.OrderTooManyException;
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
    private InvoiceDao invoiceDao;

    @Autowired
    public InvoiceServiceLayer(ConsoleDao consoleDao, GameDao gameDao, ProcessingFeeDao processingFeeDao, TaxesDao taxesDao, TShirtDao tShirtDao, InvoiceDao invoiceDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.processingFeeDao = processingFeeDao;
        this.taxesDao = taxesDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
    }

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
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(), inputObject.getQuantity()));
            returnVal.setTotal(returnVal.getTax().add((returnVal.getSubtotal().add(returnVal.getProcessing_fee()))));
        } else if (inputObject.getItem_type().equalsIgnoreCase("Console")) {
            returnVal.setConsole(consoleDao.getConsole(inputObject.getItem_id()));
            returnVal.setGame(null);
            returnVal.settShirt(null);
            Console console = consoleDao.getConsole(inputObject.getItem_id());
            unitPrice = console.getPrice();
            returnVal.setUnit_price(unitPrice);
            returnVal.setSubtotal(unitPrice.multiply(new BigDecimal(inputObject.getQuantity())));
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(), inputObject.getQuantity()));
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
            returnVal.setProcessing_fee(calculateProcessingFee(inputObject.getItem_type(), inputObject.getQuantity()));
            returnVal.setTotal(returnVal.getTax().add((returnVal.getSubtotal().add(returnVal.getProcessing_fee()))));
        }

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
        if (quantity > 10) {
            return (additionProcessingFee.add(fee)).setScale(2, RoundingMode.HALF_DOWN);
        } else {
            return fee;
        }

    }

    //UPDATES THE QUANTITY OF ITEM(4)
    public int updateInventoryQuantity(int quantityToPurchase, int product_id, String product_type) {
        if (product_type.equalsIgnoreCase("Game")) {
            int gameItemQuantity = gameDao.getGame(product_id).getQuantity();
            int updatedGameItemQuantity = gameItemQuantity - quantityToPurchase;
            if (updatedGameItemQuantity >= 0) {
                gameDao.getGame(product_id).setQuantity(updatedGameItemQuantity);
                return gameDao.getGame(product_id).getQuantity();
            } else {
                throw new OrderTooManyException();
            }
        } else if (product_type.equalsIgnoreCase("Console")) {
            int consoleItemQuantity = consoleDao.getConsole(product_id).getQuantity();
            int updatedConsoleItemQuantity = consoleItemQuantity - quantityToPurchase;
            if (updatedConsoleItemQuantity >= 0) {
                consoleDao.getConsole(product_id).setQuantity(updatedConsoleItemQuantity);
                return consoleDao.getConsole(product_id).getQuantity();
            } else {
                throw new OrderTooManyException();
            }
        } else if (product_type.equalsIgnoreCase("TShirt")) {
            int tShirtItemQuantity = consoleDao.getConsole(product_id).getQuantity();
            int updatedTShirtItemQuantity = tShirtItemQuantity - quantityToPurchase;
            if (updatedTShirtItemQuantity >= 0) {
                tShirtDao.getTShirt(product_id).setQuantity(updatedTShirtItemQuantity);
                return tShirtDao.getTShirt(product_id).getQuantity();
            } else {
                throw new OrderTooManyException();
            }
        } else {
            return 1;
        }
    }


    //ORDER QUANTITY LESS THAN OR EQUAL NUMBER OF INVENTORY ON HAND(6)
    public boolean ensureOrderQuantityLessThanOrEqualToNumberOfInventoryOnHand(int quantityToPurchase, String product_type, int product_id) {
        if (product_type.equalsIgnoreCase("Game")) {
            if (quantityToPurchase <= gameDao.getGame(product_id).getQuantity()) {
                return true;
            } else {
                return false;
            }
        } else if (product_type.equalsIgnoreCase("Console")) {
            if (quantityToPurchase <= consoleDao.getConsole(product_id).getQuantity()) {
                return true;
            } else {
                return false;
            }
        } else if (product_type.equalsIgnoreCase("TShirt")) {
            if (quantityToPurchase <= tShirtDao.getTShirt(product_id).getQuantity()) {
                return true;
            } else {
                return false;
            }

        }

        return false;
    }


    //            //CHECK FOR VALID STATE CODE(7)
    public boolean checkForStateCode(String state) throws InvalidStateException {
        if (taxesDao.getTaxRate(state).getState().length() > 1) {
            return true;
        } else {
            throw new InvalidStateException();
        }

    }

    //SAVES INVOCIE TO DATABASE
    @Transactional
    public Invoice saveInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setId(invoiceViewModel.getInvoice_id());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItem_type(invoiceViewModel.getItem_type());
        if (invoice.getItem_type().equalsIgnoreCase("Game")) {
            invoice.setItem_id(invoiceViewModel.getGame().getGame_id());
            invoice.setQuantity(invoiceViewModel.getGame().getQuantity());
            invoice.setUnit_price(invoiceViewModel.getUnit_price());
        } else if ((invoice.getItem_type().equalsIgnoreCase("Console"))) {
            invoice.setItem_id(invoiceViewModel.getConsole().getConsole_id());
            invoice.setQuantity(invoiceViewModel.getConsole().getQuantity());
            invoice.setUnit_price(invoiceViewModel.getUnit_price());
        } else if ((invoice.getItem_type().equalsIgnoreCase("TShirt"))) {
            invoice.setItem_id(invoiceViewModel.gettShirt().getT_shirt_id());
            invoice.setQuantity(invoiceViewModel.gettShirt().getQuantity());
            invoice.setUnit_price(invoiceViewModel.getUnit_price());
        }
        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessing_fee(invoiceViewModel.getProcessing_fee());
        invoice.setTotal(invoiceViewModel.getTotal());

        invoiceDao.addInvoice(invoice);
        invoice.setId(invoice.getId());
        return invoice;
    }

//            Console API

    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console getConsole(int id) {
        return consoleDao.getConsole(id);
    }

    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public List<Console> getAllConsolesByManufacturer(String manufacturer) {
        return consoleDao.getAllConsolesByManufacturer(manufacturer);
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int id) {
        consoleDao.deleteConsole(id);
    }
    //
    // Game API
    //

    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    public Game getGame(int id) {
        return gameDao.getGame(id);
    }

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getAllGamesByStudio(String studio) {
        return gameDao.getAllGamesByStudio(studio);
    }

    public List<Game> getAllGamesByEsrbRating(String esrb_rating) {
        return gameDao.getAllGamesByEsrbRating(esrb_rating);
    }

    public List<Game> getAllGamesByTitle(String title) {
        return gameDao.getAllGamesByTitle(title);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void deleteGame(int id) {
        gameDao.deleteGame(id);
    }

    //
    // TSHIRT API
    //

    public TShirt addTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }

    public TShirt getTShirt(int id) {
        return tShirtDao.getTShirt(id);
    }

    public List<TShirt> getAllTShirts() {
        return tShirtDao.getAllTShirts();
    }

    public List<TShirt> getAllTShirtsByColor(String color) {
        return tShirtDao.getAllTShirtsByColor(color);
    }

    public List<TShirt> getAllTShirtsBySize(String size) {
        return tShirtDao.getAllTShirtsBySize(size);
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }
    //
    // PROCESSING FEE API
    //

    public ProcessingFee getProcessingFee(String product_type) {
        return processingFeeDao.getProcessingFee(product_type);
    }
    //
    //SALES TAX RATE API
    //

    public StateTaxRate getTaxRate(String state) {
        return taxesDao.getTaxRate(state);
    }


}
