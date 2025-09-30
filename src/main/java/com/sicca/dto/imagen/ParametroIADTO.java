package com.sicca.dto.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroIADTO {
    private Integer id;
    private BigDecimal valor;
    private String unidadMedida;
    private Integer resultadoId;
}

