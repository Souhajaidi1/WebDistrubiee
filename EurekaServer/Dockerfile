FROM openjdk:17.0.1-jdk-slim
WORKDIR /Eureka
COPY target/EurekaServer2-0.0.1-SNAPSHOT.jar /Eureka/EurekaServer2-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "EurekaServer2-0.0.1-SNAPSHOT.jar"]
