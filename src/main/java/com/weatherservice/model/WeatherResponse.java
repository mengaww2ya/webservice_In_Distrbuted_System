package com.weatherservice.model;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private String name;
    private long dt;
    private Sys sys;
    private Clouds clouds;
    private Coord coord;
    private int visibility;
    private String base;
    private int cod;
    private long id;
    private int timezone;

    // Explicit getter for weather field
    public List<Weather> getWeather() {
        return weather;
    }

    // Explicit getter for name field
    public String getName() {
        return name;
    }

    // Explicit getter for main field
    public Main getMain() {
        return main;
    }

    // Explicit getter for sys field
    public Sys getSys() {
        return sys;
    }

    // Explicit getter for wind field
    public Wind getWind() {
        return wind;
    }

    // Explicit getter for clouds field
    public Clouds getClouds() {
        return clouds;
    }

    // Explicit getter for visibility field
    public int getVisibility() {
        return visibility;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private Integer sea_level;
        private Integer grnd_level;
        
        // Explicit getter for temp field
        public double getTemp() {
            return temp;
        }
        
        // Explicit getter for feels_like field
        public double getFeels_like() {
            return feels_like;
        }
        
        // Explicit getter for humidity field
        public int getHumidity() {
            return humidity;
        }
        
        // Explicit getter for pressure field
        public int getPressure() {
            return pressure;
        }
        
        // Explicit getter for temp_min field
        public double getTemp_min() {
            return temp_min;
        }
        
        // Explicit getter for temp_max field
        public double getTemp_max() {
            return temp_max;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
        
        // Explicit getter for main field
        public String getMain() {
            return main;
        }
        
        // Explicit getter for description field
        public String getDescription() {
            return description;
        }
        
        // Explicit getter for icon field
        public String getIcon() {
            return icon;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {
        private double speed;
        private int deg;
        private Double gust;
        
        // Explicit getter for speed field
        public double getSpeed() {
            return speed;
        }
        
        // Explicit getter for deg field
        public int getDeg() {
            return deg;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sys {
        private String country;
        private long sunrise;
        private long sunset;
        private Integer type;
        private Long id;
        
        // Explicit getter for country field
        public String getCountry() {
            return country;
        }
        
        // Explicit getter for sunrise field
        public long getSunrise() {
            return sunrise;
        }
        
        // Explicit getter for sunset field
        public long getSunset() {
            return sunset;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clouds {
        private int all;
        
        // Explicit getter for all field
        public int getAll() {
            return all;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coord {
        private double lon;
        private double lat;
    }
} 