package com.sicca.dto.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoIADTO {
    private Integer id;
    private String estadoSalud;
    private String diagnostico;
    private List<String> recomendaciones;
    private Integer imagenId;
}
