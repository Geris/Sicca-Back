package com.sicca.dto.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilDTO {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String telefono;
    private Long estadoPerfilId;
}

