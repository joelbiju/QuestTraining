package com.quest.case_study.service_centre_management;

public class CombustionEngineVehicle extends Vehicle {
    private String fuelType;
    private double engineCapacity;

    public CombustionEngineVehicle(String vin, String brand, String model, int year, double mileage, String ownerName, String fuelType, double engineCapacity) {
        super(vin, brand, model, year, mileage, ownerName);
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "["+super.toString()+",fuelType:"+fuelType+",engineCapacity:"+engineCapacity+"]";
    }
}
