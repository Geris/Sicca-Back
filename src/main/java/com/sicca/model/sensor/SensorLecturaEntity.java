package com.sicca.model.sensor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_lectura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorLecturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sensor", nullable = false)
    private SensorEntity sensor;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "fecha_medicion", nullable = false)
    private LocalDateTime fechaMedicion;
}
