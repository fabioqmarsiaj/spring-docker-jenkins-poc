FROM openjdk:17-slim
LABEL authors="Fabio Marsiaj"
COPY /build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]