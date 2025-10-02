FROM eclipse-temurin:21-jdk
COPY target/sicca-1.0.0.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
