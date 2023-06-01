#FROM amazoncorretto:8-alpine-jdk

#COPY target/crud-0.0.1-SNAPSHOT.jar backendporfolio.jar

#ENTRYPOINT ["java","-jar","/backendporfolio.jar"]

#EXPOSE 8080

# Utiliza una imagen base de Java 11
FROM openjdk:11

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/crud-0.0.1-SNAPSHOT.jar .

# Ejecuta el archivo JAR cuando el contenedor se inicie
CMD ["java", "-jar", "crud-0.0.1-SNAPSHOT.jar"]
