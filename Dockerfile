#FROM amazoncorretto:8-alpine-jdk

#COPY target/crud-0.0.1-SNAPSHOT.jar backendporfolio.jar

#ENTRYPOINT ["java","-jar","/backendporfolio.jar"]

#EXPOSE 8080

FROM openjdk:8-jdk-alpine

COPY target/crud-0.0.1-SNAPSHOT.jar /backendportfolio.jar

ENTRYPOINT ["java", "-jar", "/backendportfolio.jar"]

EXPOSE 8080
