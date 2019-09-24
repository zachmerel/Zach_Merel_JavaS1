package com.company;

public class App {

    public static Car createCar(){
        Car userCar = new Car("Honda","Accord","Sedan", "Blue","2.6L V6","CVT",4,31.7, 25218);
        return userCar;
    }

    public static ComputerMouse createComputerMouse(){
        ComputerMouse userComputerMouse = new ComputerMouse("Razer", "Naga", 960,540, new int[] {0,0} );
        return userComputerMouse;
    }

    public static Radio createRadio(){
        Radio userRadio = new Radio("Sony", "V32", 2, "WUNV", 30, true );
        return userRadio;
    }

    public static TV createTV(){
        TV userTV = new TV("Zenith", "U2121H", 83, "NBC", 55, false );
        return userTV;
    }

    public static CoffeeMaker createCoffeeMaker() {
        CoffeeMaker userCoffeemaker = new CoffeeMaker("Sunbeam", "C12", 12, 8, true );
        return userCoffeemaker;
    }

    public static Microwave createMicrowave(){
        Microwave userMicrowave = new Microwave("Haier", "X1200w", 45, "12:00", false );
        return userMicrowave;
    }


}
