package com.sicca.dto.requests.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoIARequest {
    private String estadoSalud;
    private String diagnostico;
    private String recomendacion;
    private Integer imagenId;
}
