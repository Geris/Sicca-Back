# Imagen base con JDK 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado al contenedor y lo renombra
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto que usará Cloud Run
ENV PORT=8080
EXPOSE 8080

# Comando para arrancar tu aplicación
CMD ["java", "-jar", "app.jar"]
