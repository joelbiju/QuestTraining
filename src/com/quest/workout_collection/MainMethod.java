package com.quest.workout_collection;

import java.util.*;

public class MainMethod {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, "Red");
        Car car2 = new Car("Honda", "Civic", 2018, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2021, "Black");
        Car car4 = new Car("Tesla", "Model 3", 2022, "White");

        //arrayList
        ArrayList<Car> carsArray = new ArrayList<>();
        carsArray.add(car1);
        carsArray.add(car2);
        System.out.println("ArrayList: ");
        Iterator<Car> iterator = carsArray.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println(car);
        }

        carsArray.get(1).setColor("Green");
        System.out.println("Updated ArrayList: " + carsArray);

        //HashSet
        HashSet<Car> carsHashSet = new HashSet<>();
        carsHashSet.add(car3);
        carsHashSet.add(car1);
        carsHashSet.add(car1);  //no duplicate value
        System.out.println("HashSet: ");
        Iterator<Car> iterator2 = carsHashSet.iterator();
        while (iterator2.hasNext()) {
            Car car = iterator2.next();
            System.out.println(car);
        }

        HashMap<String, Car> carHashMap = new HashMap<>();
        carHashMap.put("A", car1);
        carHashMap.put("B", car2);
        carHashMap.put("C", car4);
        System.out.println("HashMap: ");
        Iterator<Map.Entry<String, Car>> iterator3 = carHashMap.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry<String, Car> entry = iterator3.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Car c = carHashMap.get("B");
        if (c != null) {
            c.setModel("Accord");
        }
        System.out.println("Updated HashMap: ");
        Iterator<Map.Entry<String, Car>> iterator4 = carHashMap.entrySet().iterator();
        while (iterator4.hasNext()){
            Map.Entry<String, Car> entry = iterator4.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        PriorityQueue<Car> carsPriorityQueue = new PriorityQueue<>();
        carsPriorityQueue.add(car1);
        carsPriorityQueue.add(car2);
        carsPriorityQueue.add(car3);

        System.out.println("Priority Queue: ");
        Iterator<Car> iterator5 = carsPriorityQueue.iterator();
        while (iterator5.hasNext()) {
            Car car = iterator5.next();
            System.out.println(car);
        }
        System.out.println(carsPriorityQueue.poll().getColor());
    }
}
