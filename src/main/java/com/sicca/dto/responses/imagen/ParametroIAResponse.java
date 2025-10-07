package com.sicca.dto.responses.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroIAResponse {
    private Integer id;
    private Double valor;
    private Integer unidadMedida;
    private Integer resultadoId;
    private Integer tipoParametroId;
}
