package com.trilogyed.ZachMerelU1Capstone.exception;

/**
 * Exception class to handle when an order would make the quantity become negative
 */
public class OrderToManyException extends RuntimeException{

    public OrderToManyException(){

    }

    public OrderToManyException(String message){super(message);}
}
