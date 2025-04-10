package com.weatherservice.service;

import com.weatherservice.client.WeatherClient;
import com.weatherservice.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import feign.FeignException;

@Service
public class WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private final WeatherClient weatherClient;

    @Value("${weather.api.api-key}")
    private String apiKey;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Cacheable(value = "weatherCache", key = "#city")
    public WeatherResponse getWeatherByCity(String city) {
        try {
            log.info("Fetching weather data for city: {}", city);
            log.debug("Using API key: {}", apiKey);
            return weatherClient.getWeather(city, apiKey, "metric");
        } catch (FeignException e) {
            log.error("Feign client error fetching weather data for city: {}. Status: {}, Message: {}", 
                city, e.status(), e.getMessage(), e);
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        } catch (RestClientException e) {
            log.error("Rest client error fetching weather data for city: {}", city, e);
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error fetching weather data for city: {}", city, e);
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        }
    }
} 