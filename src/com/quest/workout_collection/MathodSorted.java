package com.quest.workout_collection;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class MathodSorted {
    public static void main(String[] args) {
        TreeSet<Car> carTreeSet = new TreeSet<>();

        carTreeSet.add(new Car("Toyota", "Camry", 2020, "Red"));
        carTreeSet.add(new Car("Honda", "Civic", 2018, "Blue"));
        carTreeSet.add(new Car("Ford", "Mustang", 2021, "Black"));
        carTreeSet.add(new Car("Toyota", "Hyrider", 2023, "White"));
        carTreeSet.add(new Car("Honda", "City", 2019, "Grey"));
        carTreeSet.add(new Car("Nissan", "Patrol", 2016, "Black"));

        System.out.println("\nCars sorted by year (ascending):");
        for (Car car : carTreeSet) {
            System.out.println("Car: " + car.getMake()+", Model: " + car.getModel()+", Year: " + car.getYear());
        }

        PriorityQueue<Car> carPriorityQueue = new PriorityQueue<>();
        carPriorityQueue.add(new Car("Toyota", "Camry", 2020, "Red"));
        carPriorityQueue.add(new Car("Honda", "Civic", 2018, "Blue"));
        carPriorityQueue.add(new Car("Ford", "Mustang", 2021, "Black"));
        carPriorityQueue.add(new Car("Toyota", "Hyrider", 2023, "White"));
        carPriorityQueue.add(new Car("Honda", "City", 2019, "Grey"));
        carPriorityQueue.add(new Car("Nissan", "Patrol", 2016, "Black"));

        System.out.println("\nCars sorted by year (ascending):");

        while (!carPriorityQueue.isEmpty()) {
            Car car = carPriorityQueue.poll();
            System.out.println("Car: " + car.getMake() + ", Model: " + car.getModel() + ", Year: " + car.getYear());
        }
    }
}
