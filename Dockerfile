FROM maven:3.6.0-jdk-8-alpine

COPY src /POM/src

COPY pom.xml /POM/

COPY testng.xml /POM/

RUN mvn -f /POM/pom.xml clean test -DskipTests=true