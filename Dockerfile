FROM eclipse-temurin:21-jdk
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
