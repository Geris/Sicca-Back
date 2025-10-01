# Imagen base con JDK 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Puerto que usará Cloud Run
ENV PORT=8080
EXPOSE 8080

# Perfil de Spring Boot a usar (prod)
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para arrancar la aplicación
CMD ["java", "-jar", "app.jar"]
