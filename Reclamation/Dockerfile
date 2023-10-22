FROM openjdk:17.0.1-jdk-slim
WORKDIR /Reclamation
COPY target/Reclamation-0.0.1-SNAPSHOT.jar /Reclamation/Reclamation-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "Reclamation-0.0.1-SNAPSHOT.jar"]
