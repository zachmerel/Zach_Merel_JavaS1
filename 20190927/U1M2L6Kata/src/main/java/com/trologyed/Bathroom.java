package com.trologyed;

public class Bathroom {

    private String flooringType;
    private int numberOfSinks;
    private boolean isFull;
    private boolean hasToiletPaper;
    private boolean isSmelly;

    public Bathroom(String flooringType, int numberOfSinks, boolean isFull, boolean hasToiletPaper, boolean isSmelly) {
        this.flooringType = flooringType;
        this.numberOfSinks = numberOfSinks;
        this.isFull = isFull;
        this.hasToiletPaper = hasToiletPaper;
        this.isSmelly = isSmelly;
    }

    public void hasToiletPaper(){
        this.hasToiletPaper = true;
    }

    public void hasBeenRecentlyOccupied(){
        this.isSmelly = true;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public int getNumberOfSinks() {
        return numberOfSinks;
    }

    public void setNumberOfSinks(int numberOfSinks) {
        this.numberOfSinks = numberOfSinks;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isHasToiletPaper() {
        return hasToiletPaper;
    }

    public void setHasToiletPaper(boolean hasToiletPaper) {
        this.hasToiletPaper = hasToiletPaper;
    }

    public boolean isSmelly() {
        return isSmelly;
    }

    public void setSmelly(boolean smelly) {
        isSmelly = smelly;
    }
}
