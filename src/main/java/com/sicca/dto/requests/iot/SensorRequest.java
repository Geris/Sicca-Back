package com.sicca.dto.requests.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorRequest {
    private String descripcion;
    private Integer tipoId;
    private Integer unidadMedida;
    private Integer microcontroladorId;
    private Integer lecturasId;
}
