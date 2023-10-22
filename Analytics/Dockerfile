FROM openjdk:17.0.1-jdk-slim
WORKDIR /Analytics
COPY target/Analytics-0.0.1-SNAPSHOT.jar /Analytics/Analytics-0.0.1-SNAPSHOT.jar
EXPOSE 9099
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "Analytics-0.0.1-SNAPSHOT.jar"]
