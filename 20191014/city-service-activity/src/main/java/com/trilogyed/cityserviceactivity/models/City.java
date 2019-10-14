package com.trilogyed.cityserviceactivity.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class City {

    @NotEmpty(message = "You must supply a value for name.")
    private String name;
    @NotEmpty(message = "You must supply a value for city.")
    private String state;
    @NotNull(message = "You must enter a population for the city")
    private Integer population;
    private boolean capital;

    public City() {
    }

    public City(String name,
                String state,
                 Integer population, boolean capital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population &&
                capital == city.capital &&
                Objects.equals(name, city.name) &&
                Objects.equals(state, city.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state, population, capital);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
