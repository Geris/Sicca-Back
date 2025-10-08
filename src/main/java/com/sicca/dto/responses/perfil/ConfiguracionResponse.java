package com.sicca.dto.responses.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionResponse {
    private Integer id;
    private String valor;
    private Integer perfilId;
    private ConfiguracionTipoResponse configuracionTipo;
}
