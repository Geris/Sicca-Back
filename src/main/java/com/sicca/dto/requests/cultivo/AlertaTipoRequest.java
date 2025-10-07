package com.sicca.dto.requests.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTipoRequest {
    private String nombre;
    private String descripcion;
}
