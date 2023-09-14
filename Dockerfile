FROM openjdk:17
VOLUME /main-app
ADD target/spring-CI-CD-GitHub-WithDocker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev" ,"/app.jar"]



#FROM openjdk:17-jdk-slim
#VOLUME /main-app
#ADD target/spring-boot-actions-in-docker-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app.jar"]