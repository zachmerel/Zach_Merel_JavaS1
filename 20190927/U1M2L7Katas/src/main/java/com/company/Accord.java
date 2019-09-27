package com.company;

public class Accord extends Sedan {
    private String year;
    private Engine engine;
    private Transmission transmission;

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
