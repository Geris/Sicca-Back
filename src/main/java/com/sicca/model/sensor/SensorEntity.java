package com.sicca.model.sensor;

import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.iot.MicrocontroladorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String descripcion;

    @Column(length = 50)
    private String codigoSerial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo")
    private TipoSensorEntity tipo;

    @Column(name = "unidad_medida")
    private Integer unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_microcontrolador")
    private MicrocontroladorEntity microcontrolador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultivo")
    private CultivoEntity cultivo;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorLecturaEntity> lecturas;
}
