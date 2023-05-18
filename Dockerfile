# Base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR files
COPY kafka-producer-wikimedia/target/kafka-producer-wikimedia-0.0.1-SNAPSHOT.jar /app
COPY kafka-consumer-database/target/kafka-consumer-database-0.0.1-SNAPSHOT.jar /app
COPY entrypoint.sh /app/entrypoint.sh

# Make the shell script executable
RUN chmod +x /app/entrypoint.sh

# Set the entry point to the shell script
ENTRYPOINT ["/app/entrypoint.sh"]
