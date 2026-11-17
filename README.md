# Containerization of a Microservice

This is a small Spring Boot REST microservice for the Docker experiment.

## Requirements
- JDK 17
- Maven 3.6+ (or import as an existing Maven project in Spring Tool Suite)
- Docker Desktop running

## 1. Import into Spring Tool Suite (STS)
1. Extract the ZIP file.
2. Open STS.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `microservice-docker-experiment` folder.
5. Select `pom.xml`, then click **Finish**.

## 2. Build the executable JAR
Open a terminal in the project root (the folder containing `pom.xml`) and run:

```bash
mvn clean package
```

The executable JAR will be created at `target/app-service.jar`.

## 3. Build the Docker image
Make sure Docker Desktop is running, then execute:

```bash
docker build -t app-service:v1 .
```

## 4. Run the container

```bash
docker run -d --name app-service-container -p 8080:8080 app-service:v1
```

## 5. Verify the microservice
Open this URL in a browser or REST client:

```text
http://localhost:8080/api/data
```

Expected JSON response:

```json
{
  "message": "Microservice is running successfully!",
  "application": "app-service",
  "status": "UP"
}
```

## Useful Docker commands

```bash
docker ps
docker logs app-service-container
docker stop app-service-container
docker rm app-service-container
```

If port 8080 is already in use, run the container with another host port:

```bash
docker run -d --name app-service-container -p 8081:8080 app-service:v1
```

Then open `http://localhost:8081/api/data`.

## Viva answers

**1. What is the purpose of a Dockerfile in microservice containerization?**  
A Dockerfile contains instructions to build a Docker image. It packages the application and its runtime requirements so the microservice can run consistently in different environments.

**2. How does port mapping (`-p 8080:8080`) allow external access to a containerized application?**  
The first port is the host machine port and the second is the container port. It forwards requests sent to `localhost:8080` on the host to port `8080` inside the container.
