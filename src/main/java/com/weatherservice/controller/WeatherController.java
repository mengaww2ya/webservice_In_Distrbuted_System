package com.weatherservice.controller;

import com.weatherservice.model.WeatherResponse;
import com.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Value("${weather.api.api-key}")
    private String apiKey;
    
    @Value("${weather.api.base-url}")
    private String baseUrl;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherResponse> getWeatherByCity(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherByCity(city));
    }
    
    @GetMapping(value = "/direct/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getWeatherDirectly(@PathVariable String city) {
        String url = baseUrl + "/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
} 