package com.sicca.dto.responses.imagen;

import com.sicca.dto.responses.ParametroTipoResponse;
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
    //private ResultadoIAResponse resultado;
    private ParametroTipoResponse tipoParametro;
}
