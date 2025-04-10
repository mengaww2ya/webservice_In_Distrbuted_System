package com.weatherservice.client;

import com.weatherservice.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-client", url = "${weather.api.base-url}")
public interface WeatherClient {
    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    WeatherResponse getWeather(
        @RequestParam("q") String city,
        @RequestParam("appid") String apiKey,
        @RequestParam(value = "units", defaultValue = "metric") String units
    );
} 