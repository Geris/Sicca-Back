package com.sicca.dto.requests.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionRequest {
    private String valor;
    private Integer perfilId;
    private ConfiguracionTipoRequest configuracionTipo;
}
