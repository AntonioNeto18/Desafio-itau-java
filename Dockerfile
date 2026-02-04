FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install

FROM eclipse-temurin:21-jdk
WORKDIR app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]