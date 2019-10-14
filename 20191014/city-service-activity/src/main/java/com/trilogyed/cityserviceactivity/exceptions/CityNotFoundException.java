package com.trilogyed.cityserviceactivity.exceptions;

public class CityNotFoundException extends RuntimeException{
public CityNotFoundException(String thisIsTheMessage) {
        super("The message from the CityNotFoundException is " + thisIsTheMessage);
        }
        }
