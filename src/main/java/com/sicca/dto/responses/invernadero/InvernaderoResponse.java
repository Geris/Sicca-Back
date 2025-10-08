package com.sicca.dto.responses.invernadero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvernaderoResponse {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
    private Integer estadoId;
    private Integer perfilId;
}
