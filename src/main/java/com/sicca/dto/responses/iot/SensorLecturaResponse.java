package com.sicca.dto.responses.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorLecturaResponse {
    private Integer id;
    private String nombre;
    private Integer sensorId;
    private Double valor;
    private LocalDateTime fechaMedicion;
}
