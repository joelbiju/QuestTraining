package com.quest.case_study;

public class CityManager extends WeatherOperations {

    private CityWeather[] cities = new CityWeather[5];
    private int cityCount = 0;

    public void addCity(CityWeather city) {
        if (cityCount < cities.length) {
            cities[cityCount++] = city;
        } else {
            System.out.println("Maximum City count reached");
        }
    }

    public void updateCity(String cityName, double temperature, double humidity, String condition) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equalsIgnoreCase(cityName)) {
                cities[i].setTemperature(temperature);
                cities[i].setHumidity(humidity);
                cities[i].setCondition(condition);
                return;
            }
        }
        System.out.println("City does not exist");
    }

    public void displayAllCities() {
        for (int i = 0; i < cityCount; i++) {
            System.out.println((i+1)+". "+cities[i].toString());
        }
    }

    public void displayCity(String cityName) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equalsIgnoreCase(cityName)) {
                System.out.println(cities[i].toString());
                System.out.println(cities[i].getTemperature());
                System.out.println(cities[i].getHumidity());
                System.out.println(cities[i].getCondition());
                return;
            }
        }
        System.out.println("City does not exist");
    }

    @Override
    public void extreme() {
        if (cityCount == 0) {
            System.out.println("No cities available");
            return;
        }
        CityWeather maxTempCity = cities[0];
        CityWeather minTempCity = cities[0];
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getTemperature() > maxTempCity.getTemperature()) {
                maxTempCity = cities[i];
            }
            if (cities[i].getTemperature() < minTempCity.getTemperature()) {
                minTempCity = cities[i];
            }
        }
        System.out.println("\nCity with Highest temperature: " + maxTempCity.getCityName() +"("+maxTempCity.getTemperature()+"°C)");
        System.out.println("City with minimum temperature: " + minTempCity.getCityName()+"("+minTempCity.getTemperature()+"°C)");
    }

    @Override
    public void customReport() {
        CityWeather[] sunnyCities = new CityWeather[cityCount];
        CityWeather[] rainyCities = new CityWeather[cityCount];
        CityWeather[] cloudyCities = new CityWeather[cityCount];
        int sunnyCount = 0;
        int rainyCount = 0;
        int cloudyCount = 0;

        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCondition().equalsIgnoreCase("sunny")) {
                sunnyCities[sunnyCount++] = cities[i];
            } else if (cities[i].getCondition().equalsIgnoreCase("rainy")) {
                rainyCities[rainyCount++] = cities[i];
            } else if (cities[i].getCondition().equalsIgnoreCase("cloudy")) {
                cloudyCities[cloudyCount++] = cities[i];
            }
        }
        System.out.println("\nCities grouped by Conditions:");
        System.out.println("- Sunny: ");
        if (sunnyCount == 0) {
            System.out.println(" - ");
        } else {
            for (int i = 0; i < sunnyCount; i++) {
                System.out.println(sunnyCities[i]);
            }
        }
        System.out.println("-Rainy: ");
        if (rainyCount == 0) {
            System.out.println(" - ");
        } else {
            for (int i = 0; i < rainyCount; i++) {
                System.out.println(rainyCities[i]);
            }
        }
        System.out.println("-Cloudy: ");
        if (cloudyCount == 0) {
            System.out.println(" - ");
        } else {
            for (int i = 0; i < cloudyCount; i++) {
                System.out.println(cloudyCities[i]);
            }
        }
    }

    @Override
    public void humidityAverage() {
        CityWeather[] humidityCities = new CityWeather[cityCount];
        int humidityCount = 0;

        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getHumidity() > 80) {
                humidityCities[humidityCount++] = cities[i];
            }
        }
        System.out.println("Cities with Humidity greater than 80%: ");
        if (humidityCount==0){
            System.out.println("No cities found");
        } else {
            for (int i = 0; i < humidityCount; i++) {
                System.out.println(humidityCities[i]);
            }
        }
    }

    @Override
    public void alert() {
        String[] heatWave = new String[cityCount];
        String[] lowHumidity = new String[cityCount];
        int heatCount = 0;
        int lowHumidityCount = 0;

        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getTemperature() > 40) {
                heatWave[heatCount++] = cities[i].getCityName();
            }
            if (cities[i].getHumidity() < 20) {
                lowHumidity[lowHumidityCount++] = cities[i].getCityName();
            }
        }
        System.out.println("\nAlerts");
        System.out.println("Cities with Heatwave Alert: ");
        if (heatCount == 0) {
            System.out.println(" - ");
        } else {
            for (int i = 0; i < heatCount; i++) {
                System.out.println(heatWave[i]);
            }
        }
        System.out.println("Cities with Low Humidity Alert: ");
        if (lowHumidityCount == 0){
            System.out.println(" - ");
        } else {
            for (int i = 0; i < lowHumidityCount; i++) {
                System.out.println(lowHumidity[i]);
            }
        }
    }

    @Override
    public void temperatureAverage() {
        if (cityCount==0){
            System.out.println("No cities available");
            return;
        }
        double totalTemp = 0;
        for (int i = 0; i < cityCount; i++) {
            totalTemp += cities[i].getTemperature();
        }
        double avg = totalTemp/cityCount;
        System.out.println("Average temperature: " + String.format("%.2f", avg)+" °C");
    }
}
