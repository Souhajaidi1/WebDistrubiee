FROM openjdk:8
WORKDIR /Prestation
COPY target/MSPrestation-0.0.1-SNAPSHOT.jar /Prestation/MSPrestation-0.0.1-SNAPSHOT.jar
EXPOSE 8031
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "MSPrestation-0.0.1-SNAPSHOT.jar"]
