package com.sicca.dto.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoPerfilDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}

