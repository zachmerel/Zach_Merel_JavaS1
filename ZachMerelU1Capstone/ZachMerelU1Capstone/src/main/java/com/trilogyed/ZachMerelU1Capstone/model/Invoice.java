package com.trilogyed.ZachMerelU1Capstone.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String item_type;
    private int  consoleId;
    private int tShirtId;
    private int gameId;
    private int quantity;
    private BigDecimal unit_price;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processing_fee;
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id &&
                consoleId == invoice.consoleId &&
                tShirtId == invoice.tShirtId &&
                gameId == invoice.gameId &&
                quantity == invoice.quantity &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipcode.equals(invoice.zipcode) &&
                item_type.equals(invoice.item_type) &&
                unit_price.equals(invoice.unit_price) &&
                subtotal.equals(invoice.subtotal) &&
                tax.equals(invoice.tax) &&
                processing_fee.equals(invoice.processing_fee) &&
                total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, item_type, consoleId, tShirtId, gameId, quantity, unit_price, subtotal, tax, processing_fee, total);
    }
}