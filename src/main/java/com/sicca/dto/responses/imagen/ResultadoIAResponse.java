package com.sicca.dto.responses.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoIAResponse {
    private Integer id;
    private String estadoSalud;
    private String diagnostico;
    private String recomendacion;
    private Integer imagenId;
}
