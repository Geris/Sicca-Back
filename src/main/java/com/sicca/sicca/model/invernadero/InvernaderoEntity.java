package com.sicca.model.invernadero;

import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.perfil.PerfilEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invernadero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvernaderoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(length = 50)
    private String ubicacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    private EstadoInvernaderoEntity estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CultivoEntity> cultivos;
}
