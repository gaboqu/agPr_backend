FROM amazoncorretto:11-alpine-jdk

COPY target/crud-0.0.1-SNAPSHOT.jar backendporfolio.jar

ENTRYPOINT ["java","-jar","/backendporfolio.jar"]