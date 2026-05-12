# 🌦 Weather Forecast API (Spring Boot)

A simple REST API built using Spring Boot that fetches real-time weather and forecast data using OpenWeather API.

---

## 🚀 Features

- 🌤 Get current weather by city
- 🌦 Get 5-day weather forecast
- 🧱 Layered architecture (Controller, Service, DTO)
- ⚠️ Global Exception Handling
- 🔐 API Key secured using application.properties
deploy link- https://weather-springboot-api-2.onrender.com
---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- REST API
- JSON Parsing
- Maven

---

## 📌 API Endpoints

### 1. Get Current Weather
GET /weather?city=Chennai


### 2. Get Forecast
GET /weather/forecast?city=Chennai


---

## ✅ Sample Response

### Success:
```json
{
  "status": "success",
  "data": {
    "city": "Chennai",
    "temperature": 32.5,
    "humidity": 70
  }
}
{
  "status": "error",
  "message": "City not found"
}
🔐 Configuration

Add your API key in:

application.properties
weather.api.key=YOUR_API_KEY
Run Locally
mvn spring-boot:run
