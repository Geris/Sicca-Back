package com.sicca.model.imagen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resultado_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoIAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado_salud", length = 50)
    private String estadoSalud;

    @Column(length = 50)
    private String diagnostico;

    @Column(length = 50)
    private String recomendacion;

    @OneToOne
    @JoinColumn(name = "id_imagen", nullable = false)
    private ImagenEntity imagen;

    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<ParametroIAEntity> parametrosIA;
}
