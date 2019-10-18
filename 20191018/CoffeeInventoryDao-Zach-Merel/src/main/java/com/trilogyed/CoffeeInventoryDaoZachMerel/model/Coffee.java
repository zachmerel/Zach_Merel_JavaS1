package com.trilogyed.CoffeeInventoryDaoZachMerel.model;

import java.util.Objects;

public class Coffee {

    private int coffee_id;
    private int roaster_id;
    private String name;
    private int count;
    private double unit_price;
    private String description;
    private String type;

    public Coffee() {
    }

    public Coffee(int coffee_id, int roaster_id, String name, int count,
                  double unit_price, String description, String type) {
        this.coffee_id = coffee_id;
        this.roaster_id = roaster_id;
        this.name = name;
        this.count = count;
        this.unit_price = unit_price;
        this.description = description;
        this.type = type;
    }

    public Coffee(int roaster_id, String name, int count,
                  double unit_price, String description, String type) {
        this.roaster_id = roaster_id;
        this.name = name;
        this.count = count;
        this.unit_price = unit_price;
        this.description = description;
        this.type = type;
    }

    public Coffee( String name, int count,
                  double unit_price, String description, String type) {
        this.name = name;
        this.count = count;
        this.unit_price = unit_price;
        this.description = description;
        this.type = type;
    }

    public int getCoffee_id() {
        return coffee_id;
    }

    public void setCoffee_id(int coffee_id) {
        this.coffee_id = coffee_id;
    }

    public int getRoaster_id() {
        return roaster_id;
    }

    public void setRoaster_id(int roaster_id) {
        this.roaster_id = roaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffee_id == coffee.coffee_id &&
                roaster_id == coffee.roaster_id &&
                count == coffee.count &&
                Double.compare(coffee.unit_price, unit_price) == 0 &&
                name.equals(coffee.name) &&
                Objects.equals(description, coffee.description) &&
                Objects.equals(type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffee_id, roaster_id, name, count, unit_price, description, type);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffee_id=" + coffee_id +
                ", roaster_id=" + roaster_id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", unit_price=" + unit_price +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
