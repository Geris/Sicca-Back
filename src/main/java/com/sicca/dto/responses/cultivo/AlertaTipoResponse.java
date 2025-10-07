package com.sicca.dto.responses.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTipoResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
}
