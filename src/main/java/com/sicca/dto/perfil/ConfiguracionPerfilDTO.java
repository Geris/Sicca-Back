package com.sicca.dto.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionPerfilDTO {
    private Long id;
    private String clave;
    private String valor;
    private Long perfilId;
}

