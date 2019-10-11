package com.trilogyed.weatherserviceactivity.models;

import javax.validation.constraints.Size;
import java.util.Objects;

public class Conditions {
    private int fahrenheit;
    private int celsius;
    @Size(min = 5, max = 5, message = "Zipcode must be five digits");
    private String zipcode;
    private int windSpeed;
    private String windDirectio;
    private String skies;
    private String precipitation;

    public Conditions() {
    }

    public Conditions(int fahrenheit, int celsius, int windSpeed, String windDirectio, String skies, String precipitation) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
        this.windSpeed = windSpeed;
        this.windDirectio = windDirectio;
        this.skies = skies;
        this.precipitation = precipitation;
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

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirectio() {
        return windDirectio;
    }

    public void setWindDirectio(String windDirectio) {
        this.windDirectio = windDirectio;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conditions that = (Conditions) o;
        return fahrenheit == that.fahrenheit &&
                celsius == that.celsius &&
                windSpeed == that.windSpeed &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(windDirectio, that.windDirectio) &&
                Objects.equals(skies, that.skies) &&
                Objects.equals(precipitation, that.precipitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fahrenheit, celsius, zipcode, windSpeed, windDirectio, skies, precipitation);
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "fahrenheit=" + fahrenheit +
                ", celsius=" + celsius +
                ", zipcode='" + zipcode + '\'' +
                ", windSpeed=" + windSpeed +
                ", windDirectio='" + windDirectio + '\'' +
                ", skies='" + skies + '\'' +
                ", precipitation='" + precipitation + '\'' +
                '}';
    }
}
