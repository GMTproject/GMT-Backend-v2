FROM openjdk:11-jre-slim-buster

COPY build/libs/gmt-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "-Dspring-boot.run.arguments=--datasource.url=${SPRING_DATASOURCE_URL}, --datasource.username=${SPRING_DATASOURCE_USERNAME}, --datasource.password=${SPRING_DATASOURCE_PASSWORD}"]