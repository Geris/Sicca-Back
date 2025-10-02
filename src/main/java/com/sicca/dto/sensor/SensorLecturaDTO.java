package com.sicca.dto.sensor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorLecturaDTO {
    private Long id;
    private Long sensorId;
    private Long datoSensorId;
    private String valor;
    private String fechaHora;
}

