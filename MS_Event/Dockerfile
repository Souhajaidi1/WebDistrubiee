FROM openjdk:17.0.1-jdk-slim
WORKDIR /Event
COPY target/MS_Event-0.0.1-SNAPSHOT.jar /Event/MS_Event-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "MS_Event-0.0.1-SNAPSHOT.jar"]
