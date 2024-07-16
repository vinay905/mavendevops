# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/my-app-1.0-SNAPSHOT.jar /app/my-app.jar

# Command to run the application
CMD ["java", "-jar", "my-app.jar"]
