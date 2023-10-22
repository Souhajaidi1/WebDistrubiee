FROM openjdk:17.0.1-jdk-slim
WORKDIR /Apigatway
COPY target/API_Gateway-0.0.1-SNAPSHOT.jar /Apigatway/API_Gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "API_Gateway-0.0.1-SNAPSHOT.jar"]
