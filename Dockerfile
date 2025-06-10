# Start from an official Java image
FROM eclipse-temurin:22-jdk
#testing
# Set working directory
WORKDIR /app

# Copy the jar file (assumes you build it before)
COPY target/ecomm-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "app.jar"]
