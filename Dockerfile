FROM openjdk:8
ADD target/docker-orders2.jar docker-orders2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-orders2.jar"]