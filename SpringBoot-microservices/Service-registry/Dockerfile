# Use a base image with Java 11 installed
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file and application.properties to the container
COPY target/service-registry.jar .
COPY application.properties .

# Set environment variables for the application
ENV SPRING_APPLICATION_NAME=SERVICE-REGISTRY
ENV SERVER_PORT=8761
ENV EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
ENV EUREKA_CLIENT_FETCH_REGISTRY=false

# Expose the port that the application listens on
EXPOSE 8761

# Start the Spring Boot application
CMD ["java", "-jar", "service-registry.jar"]