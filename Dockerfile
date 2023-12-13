FROM openjdk:17
EXPOSE 8082
ADD target/Forum-0.0.1-SNAPSHOT.jar Forum-docker.jar
ENTRYPOINT ["java", "-jar", "Forum-docker.jar"]