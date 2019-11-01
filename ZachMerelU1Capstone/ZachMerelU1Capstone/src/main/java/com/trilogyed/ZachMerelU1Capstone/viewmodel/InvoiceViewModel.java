package com.trilogyed.ZachMerelU1Capstone.viewmodel;

import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.Game;
import com.trilogyed.ZachMerelU1Capstone.model.TShirt;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoice_id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String item_type;
    private Console console;
    private TShirt tShirt;
    private Game game;
    private BigDecimal unit_price;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processing_fee;
    private BigDecimal total;

    public InvoiceViewModel() {
    }

    public InvoiceViewModel(int invoice_id, String name, String street, String city, String state, String zipcode, String item_type, Console console, TShirt tShirt, Game game, BigDecimal unit_price, BigDecimal subtotal, BigDecimal tax, BigDecimal processing_fee, BigDecimal total) {
        this.invoice_id = invoice_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.console = console;
        this.tShirt = tShirt;
        this.game = game;
        this.unit_price = unit_price;
        this.subtotal = subtotal;
        this.tax = tax;
        this.processing_fee = processing_fee;
        this.total = total;
    }



    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
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

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public TShirt gettShirt() {
        return tShirt;
    }

    public void settShirt(TShirt tShirt) {
        this.tShirt = tShirt;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
        InvoiceViewModel that = (InvoiceViewModel) o;
        return invoice_id == that.invoice_id &&
                name.equals(that.name) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                item_type.equals(that.item_type) &&
                Objects.equals(console, that.console) &&
                Objects.equals(tShirt, that.tShirt) &&
                Objects.equals(game, that.game) &&
                unit_price.equals(that.unit_price) &&
                subtotal.equals(that.subtotal) &&
                tax.equals(that.tax) &&
                processing_fee.equals(that.processing_fee) &&
                total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, name, city, state, zipcode, item_type, console, tShirt, game, unit_price, subtotal, tax, processing_fee, total);
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "invoice_id=" + invoice_id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", console=" + console +
                ", tShirt=" + tShirt +
                ", game=" + game +
                ", unit_price=" + unit_price +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", processing_fee=" + processing_fee +
                ", total=" + total +
                '}';
    }
}
