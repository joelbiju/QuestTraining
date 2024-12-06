package com.quest.workout.afternoon_workout.multiple_inheritance;

public class Vehicle implements Car, Bike {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.bikeWheels();
        v.carWheels();
    }

    @Override
    public void bikeWheels() {
        System.out.println("Bike has 2 Wheels");
    }

    @Override
    public void carWheels() {
        System.out.println("Car has 4 Wheels");
    }
}
