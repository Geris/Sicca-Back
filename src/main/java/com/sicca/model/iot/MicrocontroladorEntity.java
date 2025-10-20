
package com.sicca.model.iot;

import com.sicca.model.sensor.SensorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "microcontrolador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MicrocontroladorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "codigo_serial")
    private String codigoSerial;

    private String descripcion;

    @OneToMany(mappedBy = "microcontrolador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorEntity> sensores;
}
