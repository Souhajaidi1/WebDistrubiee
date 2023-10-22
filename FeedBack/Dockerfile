FROM openjdk:17.0.1-jdk-slim
WORKDIR /Feedback
COPY target/FeedBack-0.0.1-SNAPSHOT.jar /Feedback/FeedBack-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "FeedBack-0.0.1-SNAPSHOT.jar"]
