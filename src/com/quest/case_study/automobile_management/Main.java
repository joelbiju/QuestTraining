package com.quest.case_study.automobile_management;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleManagement vm = new VehicleManagement();
        CustomerManagement cm = new CustomerManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose option from below: ");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add a Customer");
            System.out.println("3. Show all Vehicles");
            System.out.println("4. Purchase a Vehicle");
            System.out.println("5. List Purchased Vehicles");
            System.out.println("6. Remove a purchased Vehicle");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    addVehicle(sc, vm);
                    break;
                }
                case 2: {
                    addCustomer(sc, cm);
                    break;
                }
                case 3: {
                    vm.printVehicles();
                    break;
                }
                case 4: {
                    purchaseVehicle(sc, cm, vm);
                    break;
                }
                case 5: {
                    System.out.print("Enter Customer id: ");
                    String customerId = sc.next();
                    Customer c = cm.customerExist(customerId);
                    if (c != null) {
                        cm.listCustomerPurchases(c);
                    }
                    break;
                }
                case 6: {
                    removePurchasedVehicle(sc, cm, vm);
                    break;
                }
                case 7: {
                    cm.serializeData();
                    System.out.println("Exiting and storing data...");
                    return;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }

        }
    }

    private static void addCustomer(Scanner sc, CustomerManagement cm) {
        try {
            System.out.print("Enter customer id: ");
            String customerId = sc.next();
            System.out.print("Enter customer name: ");
            String customerName = sc.next();
            System.out.print("Enter customer email: ");
            String customerEmail = sc.next();

            // Create and add a new customer
            cm.addNewCustomer(new Customer(customerId, customerName, customerEmail));
            System.out.println("Customer added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void purchaseVehicle(Scanner sc, CustomerManagement cm, VehicleManagement vm) {
        try {
            System.out.print("Enter vehicle id: ");
            String vehicleId = sc.next();
            System.out.print("Enter Customer ID: ");
            String customerId = sc.next();

            Customer c = cm.customerExist(customerId);
            if (c == null) {
                throw new Exception("Customer does not exist.");
            }

            Vehicle v = vm.findVehicleById(vehicleId);
            if (v == null) {
                throw new Exception("Vehicle does not exist.");
            }
            cm.purchaseVehicle(c, v, vm);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removePurchasedVehicle(Scanner sc, CustomerManagement cm, VehicleManagement vm) {
        try {
            System.out.print("Enter Customer id: ");
            String customerId = sc.next();
            System.out.print("Enter Vehicle id: ");
            String vehicleId = sc.next();

            Customer c = cm.customerExist(customerId);
            Vehicle v = vm.findRemovedVehicleById(vehicleId);

            if (c == null) {
                throw new Exception("Customer does not exist.");
            }
            if (v == null) {
                throw new Exception("Vehicle does not exist.");
            }

            cm.removePurchasedVehicle(c, v, vm);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addVehicle(Scanner sc, VehicleManagement vm) {
        System.out.print("Car/Bike: ");
        String vehicleSelection = sc.next();
        System.out.print("Enter vehicle id: ");
        String vehicleId = sc.next();
        System.out.print("Brand: ");
        String brand = sc.next();
        System.out.print("Model: ");
        String model = sc.next();
        System.out.print("Price: ");
        double price = sc.nextInt();
        if (vehicleSelection.equalsIgnoreCase("bike")) {
            System.out.print("Engine Capacity: ");
            int engineCapacity = sc.nextInt();
            vm.addVehicle(new Bike(vehicleId, brand, model, price, LocalDate.now(), engineCapacity));
        } else {
            System.out.print("Seating Capacity: ");
            int seatingCapacity = sc.nextInt();
            vm.addVehicle(new Car(vehicleId, brand, model, price, LocalDate.now(), seatingCapacity));
        }
    }
}
