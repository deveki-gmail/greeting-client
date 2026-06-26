FROM eclipse-temurin:8-jdk
ADD target/greeting-client.jar greeting-client.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","greeting-client.jar"]
