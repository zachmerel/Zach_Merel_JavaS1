package com.trologyed;

public class Kitchen {
    private  String counterTopType;
    private String stoveType;
    private String flooringType;
    private boolean hasDishwasher;
    private boolean isHot;
    private boolean isCrowded;

    public Kitchen(String counterTopType, String stoveType, String flooringType, boolean hasDishwasher, boolean isHot, boolean isCrowded) {
        this.counterTopType = counterTopType;
        this.stoveType = stoveType;
        this.flooringType = flooringType;
        this.hasDishwasher = hasDishwasher;
        this.isHot = isHot;
        this.isCrowded = isCrowded;
    }

    public void isOvenOn(){
        this.isHot = true;
    }

    public void hasPeopleStandingAround(){
        this.isCrowded = true;
    }

    public String getCounterTopType() {
        return counterTopType;
    }

    public void setCounterTopType(String counterTopType) {
        this.counterTopType = counterTopType;
    }

    public String getStoveType() {
        return stoveType;
    }

    public void setStoveType(String stoveType) {
        this.stoveType = stoveType;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHasDishwasher() {
        return hasDishwasher;
    }

    public void setHasDishwasher(boolean hasDishwasher) {
        this.hasDishwasher = hasDishwasher;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isCrowded() {
        return isCrowded;
    }

    public void setCrowded(boolean crowded) {
        isCrowded = crowded;
    }
}
