FROM openjdk:17
EXPOSE 8089
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-docker.jar

ENTRYPOINT ["java", "-jar","user-service-docker.jar"]