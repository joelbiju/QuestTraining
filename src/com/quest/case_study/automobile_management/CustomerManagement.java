package com.quest.case_study.automobile_management;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CustomerManagement implements Serializable {
    List<Customer> customers = new ArrayList<>();
    Map<Customer, Set<Vehicle>> customerVehiclesMap = new HashMap<>();
    private String fileName = "saleData.ser";

    public CustomerManagement() {
        this.customerVehiclesMap = new HashMap<>();
        deserializeData();
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


    public void serializeData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(customerVehiclesMap);
            System.out.println("Sales data has been serialized and saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while serializing sales data: " + e.getMessage());
        }
    }

    public void deserializeData() {
        Map<Customer, Set<Vehicle>> deserializedData = loadData();
        if (!deserializedData.isEmpty()) {
            this.customerVehiclesMap = deserializedData;
            System.out.println("\nDeserialized Sales Data From File:");
            deserializedData.forEach((customer, vehicles) -> {
                System.out.println("Customer: " + customer);
                vehicles.forEach(vehicle -> System.out.println("Vehicle: " + vehicle));
            });
        } else {
            System.out.println("No data to display.");
        }
    }


    private Map<Customer, Set<Vehicle>> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object deserializedObject = ois.readObject();
            if (deserializedObject instanceof Map<?, ?>) {
                Map<Customer, Set<Vehicle>> deserializedData = (Map<Customer, Set<Vehicle>>) deserializedObject;
                System.out.println("Sales data loaded from " + fileName);
                return deserializedData;
            } else {
                System.out.println("Data in file is not of the expected type.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading sales data: " + e.getMessage());
        }
        return new HashMap<>();
    }

}
