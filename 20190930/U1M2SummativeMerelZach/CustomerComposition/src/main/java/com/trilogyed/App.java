package com.trilogyed;

public class App {
    public static void main(String[] args) {
        System.out.println("Entering a new customer");
        Address shippingAddress = new Address("1600 Pennsylvania Ave NW", "Oval Office","Washington DC", "Washington DC", "20500");
        Address billingAddress = new Address("742 Evergreen Terrace","Bart's Room","Springfield", "OR", "97475");
        Customer firstCustomer = new Customer("Zach", "Merel", "zachmerel@gmail.com", "1234567890", shippingAddress,billingAddress,true);

        System.out.println(firstCustomer);
    }

}
