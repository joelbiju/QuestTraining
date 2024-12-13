package com.quest.case_study.automobile_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Vehicle implements Cloneable {
    private String vehicleId;
    private String brand;
    private String model;
    private double price;
    private LocalDate date;

    public Vehicle(String vehicleId, String brand, String model, double price, LocalDate date) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.date = date;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" +
                vehicleId + ", brand=" + brand + ", model=" +
                model + ", price=" + price + ", date=" + date + "]";
    }

    @Override
    protected Vehicle clone() {
        try {
            Vehicle cloned = (Vehicle) super.clone();
            cloned.price = this.price * 0.9;

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vehicleId);
    }
}
