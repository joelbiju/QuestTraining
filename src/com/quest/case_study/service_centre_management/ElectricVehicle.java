package com.quest.case_study.service_centre_management;

public class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private double rangePerCharge;

    public ElectricVehicle(String vin, String brand, String model, int year, double mileage, String ownerName, double batteryCapacity, double rangePerCharge) {
        super(vin, brand, model, year, mileage, ownerName);
        this.batteryCapacity = batteryCapacity;
        this.rangePerCharge = rangePerCharge;
    }

    @Override
    public String toString() {
        return "["+super.toString()+",batteryCapacity:"+batteryCapacity+",rangePerCharge:"+rangePerCharge+"]";
    }
}
