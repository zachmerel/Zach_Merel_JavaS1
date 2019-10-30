//package com.trilogyed.ZachMerelU1Capstone.service;
//
//import com.trilogyed.ZachMerelU1Capstone.dao.*;
//import com.trilogyed.ZachMerelU1Capstone.model.*;
//import com.trilogyed.ZachMerelU1Capstone.viewmodel.InvoiceViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Component
//public class InvoiceServiceLayer {
//
//    Invoice invoice;
//
//    ConsoleDao consoleDao;
//    GameDao gameDao;
//    ProcessingFeeDao processingFeeDao;
//    TaxesDao taxesDao;
//    TShirtDao tShirtDao;
//
//    @Autowired
//    public InvoiceServiceLayer(ConsoleDao consoleDao, GameDao gameDao, ProcessingFeeDao processingFeeDao, TaxesDao taxesDao, TShirtDao tShirtDao) {
//        this.consoleDao = consoleDao;
//        this.gameDao = gameDao;
//        this.processingFeeDao = processingFeeDao;
//        this.taxesDao = taxesDao;
//        this.tShirtDao = tShirtDao;
//    }
//
////    public BigDecimal calculateSalesTax (){
////
////    }
////
////    public BigDecimal calculateProcessingFee(InvoiceViewModel invoiceViewModel){
////        String itemType =invoiceViewModel.getItem_type();
////        int itemQuantity =  invoice.getQuantity();
////        BigDecimal additonalItemCost = BigDecimal.valueOf(15.49);
////        switch(itemType){
////            case "Game":
////                if(itemQuantity > 10){
////                    processingFeeDao.getProcessingFee("Game") + additonalItemCost;
////
////                }
////        }
////
////    }
//
////    @Transactional
////    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){
////        Invoice invoice = new Invoice();
////        invoice.setName(invoiceViewModel.getName());
////        invoice.setStreet(invoiceViewModel.getStreet());
////        invoice.setCity(invoiceViewModel.getCity());
////        invoice.setZipcode(invoiceViewModel.getZipcode());
////        invoice.setItem_type(invoiceViewModel.getItem_type());
////        //NEED GAME/CONSOLE/TSHIRT HERE?
////
////
////    }
//
//    //
//    //Console API
//    //
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
////    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
////
////
////        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
////        invoiceViewModel.setInvoice_id(invoice.getId());
////        invoiceViewModel.setName(invoice.getName());
////        invoiceViewModel.setStreet(invoice.getStreet());
////        invoiceViewModel.setCity(invoice.getCity());
////        invoiceViewModel.setState(invoice.getState());
////        invoiceViewModel.setZipcode(invoice.getZipcode());
////        invoiceViewModel.setItem_type(invoice.getItem_type());
////        invoiceViewModel.setUnit_price(invoice.getUnit_price());
////        invoiceViewModel.setSubtotal(invoice.getSubtotal());
////        invoiceViewModel.setTax(invoice.getTax());
////        invoiceViewModel.setProcessing_fee(invoice.getProcessing_fee());
////        invoiceViewModel.setTotal(invoice.getTotal());
////
////        Console console = consoleDao.getConsole(invoice.getConsoleId());
////        invoiceViewModel.setConsoleId(console.getConsole_id());
////
////        Game game = gameDao.getGame(invoice.getGameId());
////        invoiceViewModel.setGameId(game.getGame_id());
////
////        TShirt tShirt = tShirtDao.getTShirt(invoice.gettShirtId());
////        invoiceViewModel.settShirtId(tShirt.getT_shirt_id());
////
////        return invoiceViewModel;
////    }
//}
