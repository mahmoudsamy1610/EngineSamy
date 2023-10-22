# syntax=docker/dockerfile:1
FROM openjdk:17

WORKDIR /Autofox

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY docker-compose.yml ./
COPY browserStack.yml ./
RUN ./mvnw dependency:resolve
COPY src ./src

RUN chmod -R 777 /Autofox
RUN chmod -R 777 /Autofox/src/test/resources/testReports


CMD ["./mvnw" , "-PRunConfig" , "clean" , "test"]
