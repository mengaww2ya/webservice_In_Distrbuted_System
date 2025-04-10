#!/bin/bash

# Load environment variables
source .env

# Run with debug logging
OPENWEATHER_API_KEY=$OPENWEATHER_API_KEY \
LOGGING_LEVEL_COM_WEATHERSERVICE=DEBUG \
LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_WEB=DEBUG \
mvn spring-boot:run 