package com.example.weatherapi;

public class ForecastResponse {

    private String dateTime;
    private double temperature;
    private String description;

    public ForecastResponse(String dateTime, double temperature, String description) {
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.description = description;
    }

    public String getDateTime() { return dateTime; }
    public double getTemperature() { return temperature; }
    public String getDescription() { return description; }
}
