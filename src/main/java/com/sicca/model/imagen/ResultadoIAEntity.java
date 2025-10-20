package com.sicca.model.imagen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "resultado_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoIAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado_salud", length = 200)
    private String estadoSalud;

    @Column(length = 1000)
    private String diagnostico;

    @Column(length = 1000)
    private String recomendacion;

    @OneToOne
    @JoinColumn(name = "id_imagen", nullable = false)
    private ImagenEntity imagen;

    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroIAEntity> parametrosIA;
}
