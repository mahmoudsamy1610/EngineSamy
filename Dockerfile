# syntax=docker/dockerfile:1
FROM openjdk:17

WORKDIR /business

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY docker-compose.yml ./
COPY browserStack.yml ./


RUN ./mvnw dependency:resolve
COPY src ./src


RUN chmod -R 777 /business
RUN chmod -R 777 /business/allure-reports


CMD ["./mvnw" , "-PLocal" , "clean" , "test"]
