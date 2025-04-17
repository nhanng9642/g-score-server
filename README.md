# Gscore Application

## Overview
Gscore is a Spring Boot application designed to manage and process data efficiently. It uses Java, SQL, and Maven for development and deployment.

## Features
- Built with Spring Boot for rapid development.
- Maven for dependency management and build automation.
- SQL database integration for data storage and retrieval.

## Prerequisites
- Java JDK 21 or higher
- Maven
- Docker (optional, for containerized deployment)

### Using Docker
1. Ensure Docker is installed and running on your system.
2. Build the Docker image:
   ```bash
   docker compose up --build
   ```
3. Test the application:
   ```bash
   curl -X GET http://localhost:8080
   ```