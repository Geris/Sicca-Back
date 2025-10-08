package com.sicca.dto.responses.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroCultivoResponse {
    private Integer id;
    private Double valor;
    private Integer unidadMedida;
    private Integer tipoParametroId;
}
