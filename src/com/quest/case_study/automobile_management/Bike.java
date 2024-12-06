package com.quest.case_study.automobile_management;

import java.time.LocalDate;

public class Bike extends Vehicle {
    private int engineCapacity;

    public Bike(String vehicleId, String brand, String model, double price, LocalDate date, int engineCapacity) {
        super(vehicleId, brand, model, price, date);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\t Engine Capacity: " + engineCapacity;
    }
}
