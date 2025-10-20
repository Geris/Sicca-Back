import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    @Bean
    public OpenAPI customOpenAPI() {
        String url;
        switch (activeProfile) {
            case "prod":
                url = "https://sicca-backend-935344560393.us-south1.run.app";
                break;
            case "qa":
                url = "https://qa.sicca.com";
                break;
            default:
                url = "http://localhost:8080";
        }

        Server server = new Server()
                .url(url)
                .description("Servidor: " + activeProfile);

        return new OpenAPI().servers(List.of(server));
    }
}
