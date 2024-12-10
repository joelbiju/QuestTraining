package com.quest.case_study.service_centre_management;

import java.util.Objects;

public class Vehicle {
    private String vin;
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private String ownerName;

    public Vehicle(String vin, String brand, String model, int year, double mileage, String ownerName) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.ownerName = ownerName;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "[Vehicle Identification:"+vin+",Brand:"+brand+",Model:"+model+",Year:"+year+ ",Mileage:"+mileage+",OwnerName:"+ownerName+"]";
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null|| getClass()!=obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }*/
}
