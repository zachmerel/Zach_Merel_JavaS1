package com.trilogyed.weatherserviceactivity.models;

import javax.validation.constraints.Size;
import java.util.Objects;

public class Temperature {
    private int fahrenheit;
    private int celsius;
    @Size(min = 5, max = 5, message = "Zipcode must be five digits");
    private String zipcode;

    public Temperature() {
    }

    public Temperature(int fahrenheit, int celsius) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
    }

    public Temperature(int fahrenheit, int celsius, String zipcode) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
        this.zipcode = zipcode;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return fahrenheit == that.fahrenheit &&
                celsius == that.celsius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fahrenheit, celsius);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "fahrenheit=" + fahrenheit +
                ", celsius=" + celsius +
                '}';
    }
}
