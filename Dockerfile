FROM openjdk:17
EXPOSE 8089
LABEL authors="farah"
ADD target/Evenemnts-0.0.1-SNAPSHOT.jar Evenemnts-docker.jar
ENTRYPOINT ["java", "-jar", "Evenemnts-docker.jar"]
