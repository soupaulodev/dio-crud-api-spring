FROM openjdk:21
ADD ./docker-springboot.jar docker-springboot.jar
ENTRYPOINT ["java", "-jar", "docker-springboot.jar"]
