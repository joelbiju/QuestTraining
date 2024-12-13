package com.quest.case_study.automobile_management;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CustomerManagement implements Serializable {
    List<Customer> customers = new ArrayList<>();
    Map<Customer, Set<Vehicle>> customerVehiclesMap = new HashMap<>();

    public CustomerManagement() {
        this.customerVehiclesMap = new HashMap<>();
    }

    void addNewCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public Customer customerExist(String customerId) {
        customers.stream().anyMatch(customer -> customer.getCustomerId().equalsIgnoreCase(customerId));
        return customers.stream().filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId)).findFirst().get();
    }

    public void listCustomerPurchases(Customer customer) {
        if (customerVehiclesMap.containsKey(customer) && !customerVehiclesMap.get(customer).isEmpty()) {
            Set<Vehicle> vehicles = customerVehiclesMap.get(customer);
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("Customer " + customer.getCustomerName() + " not found with any Vehicles.");
        }
    }

    public void purchaseVehicle(Customer customer, Vehicle vehicle, VehicleManagement vehicleManagement) {
        try {
            // Check if the customer exists in the map
            if (!customerVehiclesMap.containsKey(customer)) {
                customerVehiclesMap.put(customer, new HashSet<>());
            }

            // Check if the vehicle exists
            if (!vehicleManagement.vehicleExists(vehicle.getVehicleId())) {
                throw new VehicleNotFoundException("Vehicle not found with id " + vehicle.getVehicleId());
            }

            // If both exist, proceed with the purchase
            customerVehiclesMap.get(customer).add(vehicle);
            vehicleManagement.removeVehicleFromInventory(vehicle);
            System.out.println(vehicle.getModel() + " Vehicle purchased successfully.");

        } catch (VehicleNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePurchasedVehicle(Customer customer, Vehicle vehicle, VehicleManagement vehicleManagement) {
        try {
            if (!customerVehiclesMap.containsKey(customer)) {
                throw new CustomerNotFoundException("Customer " + customer + " not found with any Vehicles.");
            }
            customerVehiclesMap.get(customer).remove(vehicle);
            vehicleManagement.returnVehicleToInventory(vehicle);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
