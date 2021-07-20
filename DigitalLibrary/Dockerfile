FROM alpine
RUN apk add openjdk8
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/DigitalLibrary.jar /app/DigitalLibrary_API.jar
COPY cacerts /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/
ENTRYPOINT ["java", "-jar", "/app/DigitalLibrary.jar"]
