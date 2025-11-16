package com.sicca.model.iot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "estado_control_equipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoControlEquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El mismo valor que usa el ESP: "ESP8266-XXXXXX"
    @Column(name = "equipo_serial", unique = true, nullable = false, length = 50)
    private String equipoSerial;

    // Bombas: se guardan como boolean en DB, pero el controlador las expone como 0/1
    @Column(name = "pump1", nullable = false)
    private boolean pump1 = false;

    @Column(name = "pump2", nullable = false)
    private boolean pump2 = false;

    @Column(name = "pump3", nullable = false)
    private boolean pump3 = false;

    @Column(name = "pump4", nullable = false)
    private boolean pump4 = false;

    @Column(name = "luz", nullable = false)
    private boolean luz = false;

    @Column(name = "vent", nullable = false)
    private boolean vent = false;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
