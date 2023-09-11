FROM openjdk:17-jdk-slim
VOLUME /main-app
ADD target/spring-3-with-postgresql-in-docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]