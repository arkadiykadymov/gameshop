FROM maven:3.6.1-jdk-8
ADD . /tmp
WORKDIR /tmp
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=0 /tmp/target/game-0.0.1-SNAPSHOT.jar /opt/
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/game-0.0.1-SNAPSHOT.jar"]