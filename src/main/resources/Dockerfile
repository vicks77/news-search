# Stage 1: Build the Java application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the build container
WORKDIR /app

# Copy the pom.xml file to cache dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code to the build container
COPY src /app/src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Create a lightweight runtime environment for the application
FROM openjdk:17-jdk-slim

# Set environment variables (include NewsAPI key as an environment variable)
ENV PORT=8080
ENV NEWS_API_KEY=your_news_api_key_here

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file from the build stage
COPY --from=build /app/target/news-report-0.0.1-SNAPSHOT.jar /app/news-report-0.0.1-SNAPSHOT.jar

# Expose the port on which the service will run
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "news-report-0.0.1-SNAPSHOT.jar"]
