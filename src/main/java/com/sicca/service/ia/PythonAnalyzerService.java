package com.sicca.service.ia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PythonAnalyzerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${python.analyzer.url}")
    private String analyzerUrl;

    public JsonNode analyzeImage(String gsUri) throws IOException {

        log.error("obteniendo token");
        String idToken="";
        try {
            idToken = getIdToken(analyzerUrl);
        } catch (Exception e) {
            log.error("Error obteniendo ID Token", e);
        }
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(idToken);

        String uri = gsUri.replace("gs://", "");
        String bucketName = uri.substring(0, uri.indexOf("/"));
        String fileName = uri.substring(uri.indexOf("/") + 1);

        log.error("bucket_name > {}, file name: {}", bucketName, fileName);
        Map<String, Object> body = Map.of(
                "bucket_name", bucketName,
                "file_name", fileName
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = rest.postForEntity(analyzerUrl, entity, String.class);
        return objectMapper.readTree(response.getBody());
    }

    private String getIdToken(String targetUrl) throws IOException {
        try {
            // Intentar credenciales por defecto (desde variable de entorno o metadata server)
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            if (!(credentials instanceof IdTokenProvider)) {
                throw new IOException("Las credenciales no son un proveedor de ID token");
            }

            // Construir token para el audience (el dominio base de tu servicio Python)
            IdTokenCredentials tokenCredential = IdTokenCredentials.newBuilder()
                    .setIdTokenProvider((IdTokenProvider) credentials)
                    .setTargetAudience("https://sicca-ia-service-935344560393.us-south1.run.app")
                    .build();

            tokenCredential.refresh();
            return tokenCredential.getAccessToken().getTokenValue();

        } catch (Exception e) {
            throw new IOException("Error obteniendo ID token", e);
        }
    }
}
