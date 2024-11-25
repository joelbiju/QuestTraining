package com.quest.case_study;

public class CityManager implements WeatherOperations {

    private CityWeather[] cityWeatherObject = new CityWeather[5];  //rename variable
    private int cityCount = 0;

    public void addCity(CityWeather city) {     //city parameter to city weather
        if (cityCount < cityWeatherObject.length) {
            cityWeatherObject[cityCount++] = city;
        } else {
            System.out.println("Maximum City count reached");
        }
    }

    public void updateCity(String cityName, double temperature, double humidity, String condition) {
        for (int i = 0; i < cityCount; i++) {
            if (cityWeatherObject[i].getCityName().equalsIgnoreCase(cityName)) {
                cityWeatherObject[i].setTemperature(temperature);
                cityWeatherObject[i].setHumidity(humidity);
                cityWeatherObject[i].setCondition(condition);
                return;
            }
        }
        System.out.println("City does not exist");
    }

    public void displayAllCities() {
        for (int i = 0; i < cityCount; i++) {
            System.out.println((i + 1) + ". " + cityWeatherObject[i].toString());
        }
    }

    public void displayCity(String cityName) {
        for (int i = 0; i < cityCount; i++) {
            if (cityWeatherObject[i].getCityName().equalsIgnoreCase(cityName)) {
                System.out.println(cityWeatherObject[i].toString());
                System.out.println(cityWeatherObject[i].getTemperature());
                System.out.println(cityWeatherObject[i].getHumidity());
                System.out.println(cityWeatherObject[i].getCondition());
                return;
            }
        }
        System.out.println("City does not exist");
    }

    @Override
    public void extreme() {
        if (cityCount == 0) {
            System.out.println("No cityWeatherObject available");
            return;
        }
        CityWeather maxTempCity = cityWeatherObject[0];
        CityWeather minTempCity = cityWeatherObject[0];
        for (int i = 0; i < cityCount; i++) {
            if (cityWeatherObject[i].getTemperature() > maxTempCity.getTemperature()) {
                maxTempCity = cityWeatherObject[i];
            }
            if (cityWeatherObject[i].getTemperature() < minTempCity.getTemperature()) {
                minTempCity = cityWeatherObject[i];
            }
        }
        System.out.println("\nCity with Highest temperature: " + maxTempCity.getCityName() + "(" + maxTempCity.getTemperature() + "°C)");
        System.out.println("City with minimum temperature: " + minTempCity.getCityName() + "(" + minTempCity.getTemperature() + "°C)");
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
            if (cityWeatherObject[i].getCondition().equalsIgnoreCase("sunny")) {
                sunnyCities[sunnyCount++] = cityWeatherObject[i];
            } else if (cityWeatherObject[i].getCondition().equalsIgnoreCase("rainy")) {
                rainyCities[rainyCount++] = cityWeatherObject[i];
            } else if (cityWeatherObject[i].getCondition().equalsIgnoreCase("cloudy")) {
                cloudyCities[cloudyCount++] = cityWeatherObject[i];
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
            if (cityWeatherObject[i].getHumidity() > 80) {
                humidityCities[humidityCount++] = cityWeatherObject[i];
            }
        }
        System.out.println("Cities with Humidity greater than 80%: ");
        if (humidityCount == 0) {
            System.out.println("No cityWeatherObject found");
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
            if (cityWeatherObject[i].getTemperature() > 40) {
                heatWave[heatCount++] = cityWeatherObject[i].getCityName();
            }
            if (cityWeatherObject[i].getHumidity() < 20) {
                lowHumidity[lowHumidityCount++] = cityWeatherObject[i].getCityName();
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
        if (lowHumidityCount == 0) {
            System.out.println(" - ");
        } else {
            for (int i = 0; i < lowHumidityCount; i++) {
                System.out.println(lowHumidity[i]);
            }
        }
    }

    @Override
    public void temperatureAverage() {
        if (cityCount == 0) {
            System.out.println("No cityWeatherObject available");
            return;
        }
        double totalTemp = 0;
        for (int i = 0; i < cityCount; i++) {
            totalTemp += cityWeatherObject[i].getTemperature();
        }
        double avg = totalTemp / cityCount;
        System.out.println("Average temperature: " + String.format("%.2f", avg) + " °C");
    }
}
