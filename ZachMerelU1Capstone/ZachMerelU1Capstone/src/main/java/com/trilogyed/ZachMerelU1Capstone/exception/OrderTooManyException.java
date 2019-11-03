package com.trilogyed.ZachMerelU1Capstone.exception;

/**
 * Exception class to handle when an order would make the quantity become negative
 */
public class OrderTooManyException extends RuntimeException{

    public OrderTooManyException(){

    }

    public OrderTooManyException(String message){super(message);}
}
