package com.sicca.dto.requests.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilRequest {
    private String nombre;
    private String email;
    private String direccion;
    private String password;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaModificacion;
    private Integer estadoId;
}
