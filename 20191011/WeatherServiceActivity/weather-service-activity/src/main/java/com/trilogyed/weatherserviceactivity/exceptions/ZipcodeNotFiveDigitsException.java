package com.trilogyed.weatherserviceactivity.exceptions;

public class ZipcodeNotFiveDigitsException extends RuntimeException {
    public ZipcodeNotFiveDigitsException(String thisIsTheMessage) {
        super("The message from the Zipcode is not five digits is " + thisIsTheMessage);
    }
}
