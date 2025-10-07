package com.sicca.dto.responses.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorResponse {
    private Integer id;
    private String descripcion;
    private Integer tipoId;
    private Integer unidadMedida;
    private Integer microcontroladorId;
    private Integer lecturasId;
}
