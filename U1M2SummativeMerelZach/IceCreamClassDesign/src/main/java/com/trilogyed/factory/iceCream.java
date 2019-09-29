package com.trilogyed.factory;

public class iceCream {
    int numberOfIngredients;
    int gallonsOfMilk;
    int poundsOfSugar;
    boolean isReadyForPackaging;
    boolean hasCorrectFatContent;
    boolean hasGoneThroughQualityControl;

    public iceCream(int numberOfIngredients, int gallonsOfMilk, int poundsOfSugar, boolean isReadyForPackaging, boolean hasCorrectFatContent, boolean hasGoneThroughQualityControl) {
        this.numberOfIngredients = numberOfIngredients;
        this.gallonsOfMilk = gallonsOfMilk;
        this.poundsOfSugar = poundsOfSugar;
        this.isReadyForPackaging = isReadyForPackaging;
        this.hasCorrectFatContent = hasCorrectFatContent;
        this.hasGoneThroughQualityControl = hasGoneThroughQualityControl;
    }

    public void hasBeenProcessed(){
        this.isReadyForPackaging = true;
        System.out.println("The ice cream has finished processing, it is now ready to be packaged.");
    }

    public void hasBeenTestForCorrectFatContent(){
        this.hasCorrectFatContent = true;
        System.out.println("This ice cream contains the proper fat content.");
    }

    public void hasBeenTasteTested(){
        this.hasGoneThroughQualityControl = true;
        System.out.println("This ice cream has been taste tested for quality control.");
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public int getGallonsOfMilk() {
        return gallonsOfMilk;
    }

    public void setGallonsOfMilk(int gallonsOfMilk) {
        this.gallonsOfMilk = gallonsOfMilk;
    }

    public int getPoundsOfSugar() {
        return poundsOfSugar;
    }

    public void setPoundsOfSugar(int poundsOfSugar) {
        this.poundsOfSugar = poundsOfSugar;
    }

    public boolean isReadyForPackaging() {
        return isReadyForPackaging;
    }

    public void setReadyForPackaging(boolean readyForPackaging) {
        isReadyForPackaging = readyForPackaging;
    }

    public boolean isHasCorrectFatContent() {
        return hasCorrectFatContent;
    }

    public void setHasCorrectFatContent(boolean hasCorrectFatContent) {
        this.hasCorrectFatContent = hasCorrectFatContent;
    }

    public boolean isHasGoneThroughQualityControl() {
        return hasGoneThroughQualityControl;
    }

    public void setHasGoneThroughQualityControl(boolean hasGoneThroughQualityControl) {
        this.hasGoneThroughQualityControl = hasGoneThroughQualityControl;
    }
}
