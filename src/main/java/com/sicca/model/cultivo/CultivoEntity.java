package com.sicca.model.cultivo;

import com.sicca.model.imagen.ImagenEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.model.iot.MicrocontroladorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cultivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "especie", nullable = false)
    private EspecieEntity especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_invernadero", nullable = false)
    private InvernaderoEntity invernadero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parametro_cultivo")
    private ParametroCultivoEntity parametroCultivo;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaEntity> alertas;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenEntity> imagenes;

    @OneToOne
    @JoinColumn(name = "microcontrolador_id") // Clave foránea en la tabla Usuario
    private MicrocontroladorEntity microcontrolador;
}
