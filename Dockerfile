# Build the application JAR first with: mvn clean package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/app-service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
