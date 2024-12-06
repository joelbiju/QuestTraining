package com.quest.case_study.automobile_management;

import java.time.LocalDate;

public class Car extends Vehicle{

    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, double price, LocalDate date, int seatingCapacity) {
        super(vehicleId, brand, model, price, date);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\t Seating Capacity: " + seatingCapacity;
    }
}
