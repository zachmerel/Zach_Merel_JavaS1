package com.trologyed;

public class Basement {

    private String flooringType;
    private int width;
    private int length;
    private int squarefootage;
    private boolean doesFlood;
    private boolean isDark;
    private boolean isFull;


    public Basement(String flooringType, int width, int length, int squarefootage, boolean doesFlood, boolean isDark, boolean isFull) {
        this.flooringType = flooringType;
        this.width = width;
        this.length = length;
        this.squarefootage = squarefootage;
        this.doesFlood = doesFlood;
        this.isDark = isDark;
        this.isFull = isFull;
    }
    public void hasLotsOfBoxes(){
        this.isFull = true;
    }
    public void turnOnLights(){
        this.isDark = false;
    }

    public void hasFoundationalCrack(){
        this.doesFlood= true;
    }

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean dark) {
        isDark = dark;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isDoesFlood() {
        return doesFlood;
    }

    public void setDoesFlood(boolean doesFlood) {
        this.doesFlood = doesFlood;
    }

    public void doesFlood(){

    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSquarefootage() {
        return squarefootage;
    }

    public void setSquarefootage(int squarefootage) {
        this.squarefootage = squarefootage;
    }
}
