package com.trilogyed.store;

public class iceCream {
    int numberOfFlavors;
    String typeOfCone;
    int numberOfToppings;
    boolean isSugarFree;
    boolean isExpired;
    boolean isOutOfStock;

    public iceCream(int numberOfFlavors, String typeOfCone, int numberOfToppings, boolean isSugarFree, boolean isExpired, boolean isOutOfStock) {
        this.numberOfFlavors = numberOfFlavors;
        this.typeOfCone = typeOfCone;
        this.numberOfToppings = numberOfToppings;
        this.isSugarFree = isSugarFree;
        this.isExpired = isExpired;
        this.isOutOfStock = isOutOfStock;
    }

    public void hasSugarAsAnIngredient(){
        this.isSugarFree = false;
        System.out.println("This flavor is not sugar free.");
    }

    public void isPastExperationDate(){
        this.isExpired = true;
        System.out.println("This ice cream is expired. Do not serve.");
    }

    public void hasLessThanOneServing(){
        this.isOutOfStock = true;
        System.out.println("This flavor of ice cream is out of stock, sorry.");
    }

    public int getNumberOfFlavors() {
        return numberOfFlavors;
    }

    public void setNumberOfFlavors(int numberOfFlavors) {
        this.numberOfFlavors = numberOfFlavors;
    }

    public String getTypeOfCone() {
        return typeOfCone;
    }

    public void setTypeOfCone(String typeOfCone) {
        this.typeOfCone = typeOfCone;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public boolean isSugarFree() {
        return isSugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        isSugarFree = sugarFree;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        isOutOfStock = outOfStock;
    }
}
