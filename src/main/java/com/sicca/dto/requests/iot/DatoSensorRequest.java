package com.sicca.dto.requests.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatoSensorRequest {
    private String sensorId;
    private Double valor;
    private LocalDateTime timestamp;
}
