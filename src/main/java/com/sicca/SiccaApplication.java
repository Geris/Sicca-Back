package com.sicca;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "SICCA API", version = "1.0"),
        servers = {
                @Server(url = "https://sicca-backend-935344560393.us-south1.run.app", description = "Cloud Run Prod")
        }
)
@SpringBootApplication
public class SiccaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SiccaApplication.class, args);
    }
}
