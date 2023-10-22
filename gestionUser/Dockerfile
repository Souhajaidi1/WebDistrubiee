FROM openjdk:8
WORKDIR /User
COPY target/gestionUser-0.0.1-SNAPSHOT.jar /User/gestionUser-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "gestionUser-0.0.1-SNAPSHOT.jar"]
