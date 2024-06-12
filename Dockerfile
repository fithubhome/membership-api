FROM openjdk:17-jdk-alpine
COPY target/membership-api-1.0-SNAPSHOT.jar app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
