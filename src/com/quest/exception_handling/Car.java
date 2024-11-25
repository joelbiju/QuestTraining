package com.quest.exception_handling;

import java.io.IOException;

public class Car extends Vehicle {
    private boolean fuelAvailable;

    public Car(String name, boolean fuelAvailable) {
        super(name);
        this.fuelAvailable = fuelAvailable;
    }

    @Override
    public void startEngine() throws IOException {
        if (!fuelAvailable) {
            throw new IOException("Fuel not available to start car");
        }
        System.out.println("Car started!");
    }

    public void speed(int distance, int time) {
        if (time == 0){
            throw new ArithmeticException("Time cannot be zero");
        }
        int speed = distance /time;
        System.out.println("Speed of car: " + speed);
    }
}
