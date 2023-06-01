#
# Build stage
#
FROM maven:3.8.4-openjdk-8 AS build
COPY . .
RUN mvn clean package

#
# Package stage
#

FROM amazoncorretto:8-alpine-jdk

COPY --from=build /target/crud-0.0.1-SNAPSHOT.jar backendporfolio.jar

ENTRYPOINT ["java","-jar","/backendporfolio.jar"]

EXPOSE 8080

