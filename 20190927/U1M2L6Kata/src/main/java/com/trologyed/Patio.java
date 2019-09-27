package com.trologyed;

public class Patio {

    private int squarefootage;
    private String surfaceType;
    private boolean hasGrill;
    private boolean isWet;
    private boolean isWarm;

    public Patio(int squarefootage, String surfaceType, boolean hasGrill, boolean isWet, boolean isWarm) {
        this.squarefootage = squarefootage;
        this.surfaceType = surfaceType;
        this.hasGrill = hasGrill;
        this.isWet = isWet;
        this.isWarm = isWarm;
    }

    public void hasRainedRecently(){
        this.isWet = true;
    }

    public void isInTheSun(){
        this.isWarm = true;
    }

    public int getSquarefootage() {
        return squarefootage;
    }

    public void setSquarefootage(int squarefootage) {
        this.squarefootage = squarefootage;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public boolean isHasGrill() {
        return hasGrill;
    }

    public void setHasGrill(boolean hasGrill) {
        this.hasGrill = hasGrill;
    }

    public boolean isWet() {
        return isWet;
    }

    public void setWet(boolean wet) {
        isWet = wet;
    }

    public boolean isWarm() {
        return isWarm;
    }

    public void setWarm(boolean warm) {
        isWarm = warm;
    }
}
