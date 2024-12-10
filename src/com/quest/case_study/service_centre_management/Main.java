package com.quest.case_study.service_centre_management;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ServiceCentre<ElectricVehicle> evServiceCentre = new ServiceCentre<>();
        ServiceCentre<CombustionEngineVehicle> ceServiceCentre = new ServiceCentre<>();

        ElectricVehicle ev1= new ElectricVehicle("EV123", "Tesla", "Model 3", 2020, 30000, "Alice", 75.0, 400.0);
        ElectricVehicle ev2 = new ElectricVehicle("EV456", "Nissan", "Leaf", 2018, 60000, "Bob", 40.0, 250.0);
        CombustionEngineVehicle ce1 =new CombustionEngineVehicle("CE123", "Toyota", "Corolla", 2012, 12000, "Charlie", "Petrol", 1.8);
        CombustionEngineVehicle ce2 =new CombustionEngineVehicle("CE456", "Ford", "Focus", 2014, 8000, "Dave", "Diesel", 2.0);

        evServiceCentre.addServicedVehicle(ev1);
        evServiceCentre.addServicedVehicle(ev2);
        ceServiceCentre.addServicedVehicle(ce1);
        ceServiceCentre.addServicedVehicle(ce2);

        Optional<Vehicle> oldestVehicle = Stream.concat(evServiceCentre.getServicedVehicles().stream(), ceServiceCentre.getServicedVehicles().stream()).
                min(Comparator.comparingInt(Vehicle::getYear));

        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(evServiceCentre.getServicedVehicles());
        allVehicles.addAll(ceServiceCentre.getServicedVehicles());

        VehicleOperations vehicleOperations = new VehicleOperations();
        vehicleOperations.groupVehiclesByType(allVehicles);

        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("C001", "Alice", "alice@example.com", ev1);
        Customer customer2 = new Customer("C002", "Bob", "bob@example.com", ev2);
        Customer customer3 = new Customer("C003", "Charlie", "charlie@example.com", ce1);
        Customer customer4 = new Customer("C004", "Dave", "dave@example.com", ce2);

        CustomerBookingsMap bookingsMap = new CustomerBookingsMap();

        try{
            bookingsMap.addBooking(customer1, new ServiceBooking("B001", customer1, LocalDateTime.now().plusDays(5), "Battery Check", 150.0));
            bookingsMap.addBooking(customer2, new ServiceBooking("B002", customer2, LocalDateTime.now().plusDays(3), "General Maintenance", 200.0));
            bookingsMap.addBooking(customer3, new ServiceBooking("B003", customer3, LocalDateTime.now().plusDays(10), "Oil Change", 100.0));
            bookingsMap.addBooking(customer4, new ServiceBooking("B004", customer4, LocalDateTime.now().plusDays(7), "Engine Check", 250.0));
        } catch (InvalidBookingDateException e){
            e.printStackTrace();
        }


        bookingsMap.getAllCustomers().forEach(System.out::println);
        bookingsMap.getAllServiceBookings().forEach(System.out::println);

    }
}
