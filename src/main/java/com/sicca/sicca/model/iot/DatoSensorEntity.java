package com.sicca.model.iot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "datos_sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatoSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private Double valor;
    private LocalDateTime timestamp;
}
