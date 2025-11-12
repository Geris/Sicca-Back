package com.sicca.model.cultivo;

import com.sicca.model.imagen.ImagenEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.model.iot.MicrocontroladorEntity;
import com.sicca.model.sensor.SensorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cultivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 50)
    private String tipo;

    @Column(length = 50)
    private String severidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especie", nullable = false)
    private EspecieEntity especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_invernadero", nullable = false)
    private InvernaderoEntity invernadero;

    @OneToMany(mappedBy = "microcontrolador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorEntity> sensores;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroCultivoEntity> parametroCultivo;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaEntity> alertas;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenEntity> imagenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "microcontrolador_id", nullable = false)
    private MicrocontroladorEntity microcontrolador;

}
