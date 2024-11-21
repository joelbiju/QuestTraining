package com.quest.case_study;

import java.util.Scanner;

public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CityManager cm1 = new CityManager();

        System.out.println("\n--- Welcome to the Weather Monitoring System ---");
        while (true){
            System.out.println("\n1. Add a new City");
            System.out.println("2. View all Cities");
            System.out.println("3. Generate Reports");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidInt(sc);
            sc.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter City name: ");
                    String cityName = sc.nextLine();
                    System.out.print("Enter temperature (°C): ");
                    double temperature = sc.nextDouble();
                    System.out.print("Enter humidity (%): ");
                    double humidity = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Condition (sunny/rainy/cloudy): ");
                    String condition = sc.nextLine();

                    CityWeather newCity = new CityWeather(cityName, temperature, humidity, condition);
                    cm1.addCity(newCity);
                    break;
                }
                case 2: {
                    System.out.println("Displaying all Cities");
                    cm1.displayAllCities();
                    break;
                }
                case 3: {
                    System.out.println("\nGenerating Reports");
                    cm1.extreme();
                    cm1.humidityAverage();
                    cm1.customReport();
                    cm1.temperatureAverage();
                    cm1.alert();
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
            break;
        }
    }

    public static int getValidInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Invalid input, please enter a positive number");
                }
            } else {
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }
    }
}
