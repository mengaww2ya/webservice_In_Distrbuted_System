package com.weatherservice.controller;

import com.weatherservice.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/test")
public class ApiTestController {

    private final RestTemplate restTemplate = new RestTemplate();
    
    @Value("${weather.api.api-key}")
    private String apiKey;
    
    @Value("${weather.api.base-url}")
    private String baseUrl;

    @GetMapping("/weather")
    public String testWeatherApi(@RequestParam(defaultValue = "London") String city) {
        try {
            String url = baseUrl + "/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            StringBuilder response = new StringBuilder();
            response.append("API URL: ").append(url).append("\n\n");
            
            try {
                WeatherResponse weather = restTemplate.getForObject(url, WeatherResponse.class);
                response.append("API Response:\n");
                if (weather != null) {
                    response.append("City: ").append(weather.getName()).append("\n");
                    response.append("Full Weather Object: ").append(weather).append("\n\n");
                    
                    if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
                        response.append("Weather: ").append(weather.getWeather().get(0).getMain()).append("\n");
                        response.append("Description: ").append(weather.getWeather().get(0).getDescription()).append("\n");
                    } else {
                        response.append("Weather data is null or empty\n");
                    }
                    if (weather.getMain() != null) {
                        response.append("Temperature: ").append(weather.getMain().getTemp()).append("°C\n");
                    } else {
                        response.append("Temperature data is null\n");
                    }
                } else {
                    response.append("Received null response from API\n");
                }
            } catch (Exception e) {
                response.append("API Error: ").append(e.getMessage()).append("\n");
                response.append("Error type: ").append(e.getClass().getName()).append("\n");
                if (e.getCause() != null) {
                    response.append("Cause: ").append(e.getCause().getMessage()).append("\n");
                }
                e.printStackTrace();
            }
            
            return response.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
} 