# syntax=docker/dockerfile:1
FROM openjdk:17

WORKDIR /EngineSamy

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY docker-compose.yml ./
COPY browserstack.yml ./


RUN ./mvnw dependency:resolve
COPY src ./src


RUN chmod -R 777 /EngineSamy
RUN chmod -R 777 /EngineSamy/allure-reports


CMD ["./mvnw" , "-PLocal" , "clean" , "test"]
