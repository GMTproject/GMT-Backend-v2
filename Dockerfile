FROM openjdk:11-jre-slim-buster

COPY build/libs/gmt-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "-Dspring-boot.run.arguments=--datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_SCHEMA}, --datasource.username=${DB_USER}, --datasource.password=${DB_PASSWORD}"]