package com.trilogyed.ZachMerelU1Capstone.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class InputObject {

    private int id;
    @NotNull(message = "please enter name")
    private String name;
    @NotNull(message = "please enter street")
    private String street;
    @NotNull(message = "please enter city")
    private String city;
    @NotNull(message = "please enter state")
    private String state;
    @NotNull(message = "please enter zipcode")
    private String zipcode;
    @NotNull(message = "please enter item type")
    private String item_type;
    @NotNull(message = "please enter item id")
    private int  item_id;
    @NotNull(message = "please enter quantity")
    @Min(1)
    private int quantity;


    public InputObject() {
    }

    public InputObject(String name, String street, String city, String state, String zipcode, String item_type, int item_id, int quantity) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public InputObject(int id, String name, String street, String city, String state, String zipcode, String item_type, int item_id, int quantity) {

        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.item_id = item_id;
        this.quantity = quantity;
    }

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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputObject that = (InputObject) o;
        return id == that.id &&
                item_id == that.item_id &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                item_type.equals(that.item_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, item_type, item_id, quantity);
    }

    @Override
    public String toString() {
        return "InputObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }
}
