FROM openjdk:21-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} example.jar
ENTRYPOINT ["java","-jar","/example.jar"]