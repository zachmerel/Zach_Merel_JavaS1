package com.trilogyed.ZachMerelU1Capstone.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    private int t_shirt_id;
    @NotNull(message = "please enter size")
    private String size;
    @NotNull(message = "please enter color")
    private String color;
    @NotNull(message = "please enter description")
    private String description;
    @NotNull(message = "please enter price")
    private BigDecimal price;
    @NotNull(message = "please enter quantity")
    @Min(0)
    private int quantity;

    public TShirt() {
    }

    public TShirt(String size, String color, String description, BigDecimal price, int quantity) {
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public TShirt(String size, String color, String description, BigDecimal price) {
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
    }

    public TShirt(int t_shirt_id, String size, String color, String description, BigDecimal price, int quantity) {
        this.t_shirt_id = t_shirt_id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(int t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        TShirt tShirt = (TShirt) o;
        return t_shirt_id == tShirt.t_shirt_id &&
                quantity == tShirt.quantity &&
                size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description) &&
                price.equals(tShirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_shirt_id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "t_shirt_id=" + t_shirt_id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
