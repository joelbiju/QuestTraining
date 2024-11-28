package com.quest.case_study.weather_monitoring;

public class CityWeather {
    private String cityName;
    private double temperature;
    private double humidity;
    private String condition;

    public CityWeather(String cityName, double temperature, double humidity, String condition) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "City: " + cityName + ", Temperature: " + temperature + "°C, Humidity: " + humidity + "%, Condition: " + condition;
    }
}
