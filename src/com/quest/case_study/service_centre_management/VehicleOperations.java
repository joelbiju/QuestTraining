package com.quest.case_study.service_centre_management;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VehicleOperations {

    public static Predicate<Vehicle> highMileageAndOldVehicle = v -> v.getMileage() > 50000 && v.getYear() < 2015;

    public static Consumer<Vehicle> vehicleConsumer = v -> System.out.println(v.getVin() + " " + v.getMileage());

    public static Supplier<ElectricVehicle> randomEV = () -> {
        Random rand = new Random();
        String vin = "EV" + rand.nextInt(1000);
        double mileage = rand.nextDouble(1000);
        int year = rand.nextInt(2015, 2024);
        double batteryCapacity = rand.nextDouble(100000);
        double rangePerCharge = rand.nextDouble(200, 1000);
        return new ElectricVehicle(vin, "RandomBrand", "RandomModel", year, mileage, "RandomOwner", batteryCapacity, rangePerCharge);
    };

    Function<Vehicle, Double> calculateResaleValue = v->{
        double originalPrice = 30000;
        double depreciationPrice = 0.15;
        int yearUsed = 2024 - v.getYear();
        return (originalPrice - (depreciationPrice*yearUsed));
    };


    public void groupVehiclesByType(List<Vehicle> allVehicles) {
        int electricCount = (int) allVehicles.stream().filter(v -> v instanceof ElectricVehicle).count();
        int combustionCout = (int) allVehicles.stream().filter(v -> v instanceof CombustionEngineVehicle).count();

        System.out.println("Electric Vehicles: "+electricCount);
        System.out.println("Combustion Engine: "+combustionCout);
    }

}
