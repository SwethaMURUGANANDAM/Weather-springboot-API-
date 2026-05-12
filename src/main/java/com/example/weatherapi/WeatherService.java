package com.example.weatherapi;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value; // IMPORTANT import
import org.springframework.stereotype.Service;

import java.net.*;
import java.io.*;
import org.json.JSONArray;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class WeatherService {

    @Value("${weather.api.key}")   // 👈 inga add pannanum
    private String apiKey;

    public WeatherResponse getWeather(String city) {

        String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject obj = new JSONObject(response.toString());

            return new WeatherResponse(
                    obj.getString("name"),
                    obj.getJSONObject("main").getDouble("temp"),
                    obj.getJSONObject("main").getInt("humidity")
            );

        } catch (Exception e) {
            throw new RuntimeException("City not found or API error");
        }
    }


    public List<ForecastResponse> getForecast(String city) {

        String urlString = "https://api.openweathermap.org/data/2.5/forecast?q="
                + city + "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject obj = new JSONObject(response.toString());
            JSONArray list = obj.getJSONArray("list");

            List<ForecastResponse> result = new ArrayList<>();

            for (int i = 0; i < list.length(); i++) {
                JSONObject item = list.getJSONObject(i);

                String date = item.getString("dt_txt");
                double temp = item.getJSONObject("main").getDouble("temp");
                String desc = item.getJSONArray("weather")
                        .getJSONObject(0)
                        .getString("description");

                result.add(new ForecastResponse(date, temp, desc));
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Forecast fetch failed");
        }
    }
}