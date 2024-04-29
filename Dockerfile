FROM openjdk:17-jdk-alpine
ENV PROFILE=docker
WORKDIR /app
COPY target/AddFoodService-0.0.1-SNAPSHOT.jar /app
COPY env.properties /app
EXPOSE 8082
CMD ["java", "-jar", "AddFoodService-0.0.1-SNAPSHOT.jar"]