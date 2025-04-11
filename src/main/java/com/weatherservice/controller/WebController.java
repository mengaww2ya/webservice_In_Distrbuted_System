package com.weatherservice.controller;
import com.weatherservice.model.WeatherResponse;
import com.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
@Controller
public class WebController {
    private final WeatherService weatherService;
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Value("${weather.api.api-key}")
    private String apiKey;
    
    @Value("${weather.api.base-url}")
    private String baseUrl;

    public WebController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/weather")
    public String weatherForm() {
        return "weather-form";
    }
    
    @PostMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        try {
            WeatherResponse weather = null;
            try {
                // First try using the service
                weather = weatherService.getWeatherByCity(city);
            } catch (Exception e) {
                // If service fails, use direct REST call
                String url = baseUrl + "/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
                weather = restTemplate.getForObject(url, WeatherResponse.class);
            }
            
            model.addAttribute("weather", weather);
            model.addAttribute("city", city);
            
            // Add background class based on weather condition
            if (weather != null && weather.getWeather() != null && !weather.getWeather().isEmpty()) {
                String condition = weather.getWeather().get(0).getMain().toLowerCase();
                switch (condition) {
                    case "clear":
                        model.addAttribute("backgroundClass", "clear-sky");
                        break;
                    case "clouds":
                        model.addAttribute("backgroundClass", "cloudy");
                        break;
                    case "rain":
                    case "drizzle":
                        model.addAttribute("backgroundClass", "rainy");
                        break;
                    case "thunderstorm":
                        model.addAttribute("backgroundClass", "thunderstorm");
                        break;
                    case "snow":
                        model.addAttribute("backgroundClass", "snowy");
                        break;
                    case "mist":
                    case "smoke":
                    case "haze":
                    case "dust":
                    case "fog":
                        model.addAttribute("backgroundClass", "misty");
                        break;
                    default:
                        model.addAttribute("backgroundClass", "default");
                        break;
                }
            } else {
                model.addAttribute("backgroundClass", "default");
            }
            
            return "weather-result";
        } catch (Exception e) {
            model.addAttribute("error", "Could not retrieve weather data for '" + city + "'. " + e.getMessage());
            return "error";
        }
    }
} 