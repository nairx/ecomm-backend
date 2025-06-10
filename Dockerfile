# Start from an official Java image
FROM eclipse-temurin:17-jdk-jammy
#testing
# Set working directory
WORKDIR /app

# Copy the jar file (assumes you build it before)
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "app.jar"]
