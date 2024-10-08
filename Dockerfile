
FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk
RUN apt-get install -y maven

COPY . .

RUN mvn -Dmaven.wagon.http.retryHandler.count=5 clean package -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080

COPY --from=build /target/BackgroundVerification-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
