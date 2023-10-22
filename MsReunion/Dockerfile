FROM openjdk:17.0.1-jdk-slim
WORKDIR /Reunion
COPY target/MsReunion-0.0.1-SNAPSHOT.jar /Reunion/MsReunion-0.0.1-SNAPSHOT.jar
EXPOSE 9091
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "MsReunion-0.0.1-SNAPSHOT.jar"]
