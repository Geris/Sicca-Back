package com.sicca.dto.sensor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorDTO {
    private Long id;
    private String nombre;
    private Long tipoSensorId;
    private Long cultivoId;
}
