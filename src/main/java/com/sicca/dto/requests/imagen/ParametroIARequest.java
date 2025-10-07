package com.sicca.dto.requests.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroIARequest {
    private Double valor;
    private Integer unidadMedida;
    private Integer resultadoId;
    private Integer tipoParametroId;
}
