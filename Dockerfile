FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

COPY . .

RUN mvn clean package -DskipTests=true

FROM openjdk:21

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

COPY data.csv /app/data.csv

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
