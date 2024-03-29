package com.trilogyed.ZachMerelU1Capstone.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {

    private int game_id;
    @NotNull(message = "please enter title")
    private String title;
    @NotNull(message = "please enter esrb rating")
    private String esrb_rating;
    @NotNull(message = "please enter description")
    private String description;
    @NotNull(message = "please enter price")
    private BigDecimal price;
    @NotNull(message = "please enter studio")
    private String studio;
    @Min(0)
    private int quantity;

    public Game() {
    }

    public Game(String title, String esrb_rating, String description, BigDecimal price, String studio, int quantity) {
        this.title = title;
        this.esrb_rating = esrb_rating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public Game(String title, String esrb_rating, String description, BigDecimal price, String studio) {
        this.title = title;
        this.esrb_rating = esrb_rating;
        this.description = description;
        this.price = price;
        this.studio = studio;
    }

    public Game(int game_id, String title, String esrb_rating, String description, BigDecimal price, String studio, int quantity) {
        this.game_id = game_id;
        this.title = title;
        this.esrb_rating = esrb_rating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        Game game = (Game) o;
        return game_id == game.game_id &&
                quantity == game.quantity &&
                title.equals(game.title) &&
                esrb_rating.equals(game.esrb_rating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", esrb_rating='" + esrb_rating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
