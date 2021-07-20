FROM alpine
RUN apk add openjdk8
EXPOSE 8080
RUN mkdir -p /app/
ADD target/DigitalLibrary-0.0.1-SNAPSHOT.jar /app/DigitalLibrary-0.0.1-SNAPSHOT.jar
#COPY cacerts /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/
ENTRYPOINT ["java", "-jar", "/app/DigitalLibrary-0.0.1-SNAPSHOT.jar"]
