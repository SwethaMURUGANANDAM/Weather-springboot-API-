package com.example.weatherapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ApiResponse<WeatherResponse> getWeather(@RequestParam String city) {

        WeatherResponse response = weatherService.getWeather(city);

        return new ApiResponse<>("success", response);
    }
    @GetMapping("/forecast")
    public List<ForecastResponse> getForecast(@RequestParam String city) {
        return weatherService.getForecast(city);
    }
}