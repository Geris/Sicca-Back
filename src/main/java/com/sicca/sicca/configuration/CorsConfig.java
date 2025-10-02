package com.sicca.sicca.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir todas las peticiones de todos los orígenes
        registry.addMapping("/**")
                .allowedOrigins("*") // Permitir todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Permitir los métodos necesarios
                .allowedHeaders("*") // Permitir todos los headers
                .allowCredentials(true) // Permitir credenciales (si es necesario)
                .maxAge(3600); // Configura el tiempo máximo de cache de la preflight request
    }

}
