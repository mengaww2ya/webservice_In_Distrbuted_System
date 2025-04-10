# Distributed Weather Service

A distributed weather service built with Spring Boot that demonstrates various distributed system concepts while providing weather information using the OpenWeatherMap API.

## Features

- REST API for weather information
- Service discovery with Eureka
- Caching with Caffeine
- Load balancing support
- Fault tolerance
- API Gateway pattern support
- Distributed tracing ready

## Prerequisites

- Java 17 or higher
- Maven
- OpenWeatherMap API key

## Setup

1. Clone the repository
2. Set your OpenWeatherMap API key as an environment variable:
   ```bash
   export OPENWEATHER_API_KEY=your_api_key_here
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Get Weather by City
```
GET /api/weather/{city}
```

Example:
```
GET /api/weather/London
```

Response:
```json
{
  "main": {
    "temp": 20.5,
    "feels_like": 19.8,
    "temp_min": 19.0,
    "temp_max": 22.0,
    "pressure": 1015,
    "humidity": 65
  },
  "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01d"
    }
  ],
  "wind": {
    "speed": 3.6,
    "deg": 250
  },
  "name": "London",
  "dt": 1616169600,
  "sys": {
    "country": "GB",
    "sunrise": 1616134567,
    "sunset": 1616178234
  }
}
```

## Distributed System Features

1. **Service Discovery**: The service registers with Eureka for service discovery
2. **Caching**: Implements caching using Caffeine to reduce API calls
3. **Load Balancing**: Ready to work with load balancers
4. **Fault Tolerance**: Includes basic error handling and retry mechanisms
5. **API Gateway**: Can be integrated with API Gateway patterns

## Configuration

The application can be configured through `application.yml`. Key configurations include:

- Server port
- Eureka client settings
- OpenWeatherMap API settings
- Cache settings
- Actuator endpoints

## Monitoring

The service includes Spring Boot Actuator endpoints for monitoring:
- Health check: `/actuator/health`
- Metrics: `/actuator/metrics`
- Info: `/actuator/info` 