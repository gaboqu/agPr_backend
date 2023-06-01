FROM amazoncorretto:8-alpine-jdk

COPY --from=build target/crud-0.0.1-SNAPSHOT.jar backendporfolio.jar

ENTRYPOINT ["java","-jar","/backendporfolio.jar"]

EXPOSE 8080

