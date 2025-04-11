# 🌦️ Distributed Weather Service

A **distributed weather service** built with **Spring Boot** that showcases various distributed system concepts while providing real-time weather information using the **OpenWeatherMap API**. The service includes an **interactive UI** for making requests and viewing responses.

---

## ✨ Features

- 🌐 **REST API** for weather information
- 🖥️ **Interactive UI** for request and response visualization
- 🔍 **Service Discovery** with Eureka
- ⚡ **Caching** with Caffeine for faster responses
- ⚖️ **Load Balancing** ready
- 🛡️ **Fault Tolerance** mechanisms
- 🚪 **API Gateway** pattern support
- 🕵️ **Distributed Tracing** enabled

---

## 🛠️ Prerequisites

Before you begin, ensure you have the following installed:

- ☕ **Java 17** or higher
- 🛠️ **Maven**
- 🔑 **OpenWeatherMap API Key**

---

## 🚀 Setup

Follow these steps to get started:

1. **Clone the repository**:
  ```bash
  git clone https://github.com/mengaww2ya/webservice_In_Distrbuted_System
  cd webservice_In_Distrbuted_System
  ```

2. **Set your OpenWeatherMap API key**:
  ```bash
  # Obtain your OpenWeatherMap API Key

  To use this service, you need an API key from OpenWeatherMap. Follow these steps to get your API key:

  1. Visit the [OpenWeatherMap website](https://openweathermap.org/).
  2. Sign up for a free account or log in if you already have one.
  3. Navigate to the "API Keys" section in your account dashboard.
  4. Generate a new API key or use an existing one.

  Once you have your API key, set it as an environment variable:

  ```bash
  export OPENWEATHER_API_KEY=your_api_key_here
  ```
  ```

3. **Build the project**:
  ```bash
  mvn clean install
  ```

4. **Run the application**:
  - Option 1:
    ```bash
    mvn spring-boot:run
    ```
  - Option 2:
    ```bash
    mvn clean install && ./debug.sh
    ```

5. **Access the Interactive UI**:
  Open your browser and navigate to `http://localhost:8080`. Use the UI to make requests and view responses interactively.

---

## 🌐 API Endpoints

### 🔍 Get Weather by City
**Endpoint**:  
```
GET /api/weather/{city}
```

**Example**:  
```
GET /api/weather/London
```

**Sample Response**:
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

---

## 🏗️ Distributed System Features

1. **🔍 Service Discovery**: Automatically registers with Eureka for service discovery.
2. **⚡ Caching**: Uses Caffeine to reduce API calls and improve performance.
3. **⚖️ Load Balancing**: Compatible with load balancers for high availability.
4. **🛡️ Fault Tolerance**: Includes error handling and retry mechanisms.
5. **🚪 API Gateway**: Easily integrates with API Gateway patterns.
6. **🖥️ Interactive UI**: Provides a user-friendly interface for testing and exploring the service.

---

## ⚙️ Configuration

The application is highly configurable via `application.yml`. Key configurations include:

- 🌐 **Server Port**
- 🔍 **Eureka Client Settings**
- 🌦️ **OpenWeatherMap API Settings**
- ⚡ **Cache Settings**
- 📊 **Actuator Endpoints**

---

## 📊 Monitoring

Monitor the service using **Spring Boot Actuator** endpoints:

- 🩺 **Health Check**: `/actuator/health`
- 📈 **Metrics**: `/actuator/metrics`
- ℹ️ **Info**: `/actuator/info`

---

## 🎯 Get Started Today!

Clone the repository, set up your environment, and start exploring the power of distributed systems with this weather service! 🌟