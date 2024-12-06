package com.quest.case_study.automobile_management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleManagement {
    private List<Vehicle> vehiclesList = new ArrayList<>();
    private List<Vehicle> removedVehicleList = new ArrayList<>();

    public VehicleManagement() {
        this.vehiclesList = new ArrayList<>();
        initializeVehicles();
    }

    private void initializeVehicles() {
        vehiclesList.add(new Car("C001", "Toyota", "Camry", 30000, LocalDate.of(2022, 1, 22), 5));
        vehiclesList.add(new Car("C002", "Honda", "Civic", 25000, LocalDate.of(2022, 6, 15), 5));
        vehiclesList.add(new Car("C003", "Ford", "Mustang", 50000, LocalDate.of(2020, 8, 20), 4));
        vehiclesList.add(new Bike("B001", "Yamaha", "R15", 1500, LocalDate.of(2023, 1, 5), 155));
        vehiclesList.add(new Bike("B002", "Royal Enfield", "Classic 350", 2000, LocalDate.of(2022, 12, 25), 350));
    }

    public Vehicle findVehicleById(String vehicleId) {
        return vehiclesList.stream().filter(v -> v.getVehicleId().equalsIgnoreCase(vehicleId)).findFirst().orElse(null);
    }

    public void addVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    public void getVehicleByBrand(String brand) {
        List<Vehicle> filteredVehicles = vehiclesList.stream().filter(v -> v.getBrand().equalsIgnoreCase(brand)).toList();

        System.out.println("Vehicles from brand: " + brand + ": ");
        filteredVehicles.forEach(System.out::println);
    }

    public boolean vehicleExists(String vehicleId) {
        return vehiclesList.stream().anyMatch(v -> v.getVehicleId().equalsIgnoreCase(vehicleId));
    }

    public void printVehicles() {
        vehiclesList.forEach(System.out::println);
    }

    public void removeVehicleFromInventory(Vehicle vehicle) {
        vehiclesList.remove(vehicle);
        removedVehicleList.add(vehicle);
    }

    public Vehicle findRemovedVehicleById(String vehicleId) {
        return removedVehicleList.stream().filter(v -> v.getVehicleId().equalsIgnoreCase(vehicleId)).findFirst().orElse(null);
    }

    public void returnVehicleToInventory(Vehicle vehicle) {
        vehiclesList.add(vehicle);
        removedVehicleList.remove(vehicle);
    }
}
