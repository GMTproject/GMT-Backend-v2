FROM openjdk:11-jre-slim-buster

COPY build/libs/gmt-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "-Dspring-boot.run.arguments=--datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_SCHEMA}, --datasource.username=${DB_USER}, --datasource.password=${DB_PASSWORD},--spring.redis.host=${SPRING_REDIS_HOST}, --spring.redis.port=${SPRING_REDIS_PORT}, --jwt.accessSecret=${JWT_ACCESS_SECRET}, --jwt.refreshSecret=${JWT_REFRESH_SECRET}, --jwt.time.accessTime=${JWT_ACCESS_TIME}, --jwt.time.refreshTime=${JWT_REFRESH_TIME}, --gauth.clientId=${GAUTH_CLIENTID}, --gauth.clientSecret=${GAUTH_CLIENT_SECRET}, --gauth.redirectUri=${GAUTH_REDIRECT_URI}"]