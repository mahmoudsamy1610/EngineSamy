# syntax=docker/dockerfile:1
FROM openjdk:17

WORKDIR /autofox

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY docker-compose.yml ./
COPY browserStack.yml ./


RUN ./mvnw dependency:resolve
COPY src ./src


RUN chmod -R 777 /autofox
RUN chmod -R 777 /autofox/allure-reports


CMD ["./mvnw" , "-PLocal" , "clean" , "test"]
