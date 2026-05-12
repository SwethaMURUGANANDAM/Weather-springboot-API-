package com.example.weatherapi;

public class WeatherResponse {

    private String city;
    private double temperature;
    private int humidity;

    public WeatherResponse(String city, double temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() { return city; }
    public double getTemperature() { return temperature; }
    public int getHumidity() { return humidity; }
}