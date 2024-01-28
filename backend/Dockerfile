FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=build/libs/backend-0.0.1-SNAPSHOT.jar
ARG PROFILES
ARG ENV
COPY ${JAR_FILE} backend.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "/backend.jar"]
