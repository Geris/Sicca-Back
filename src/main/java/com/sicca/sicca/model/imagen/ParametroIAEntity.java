package com.sicca.model.imagen;

import com.sicca.model.ParametroCultivoIAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parametro_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametroIAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;

    @Column(name = "unidad_medida")
    private Integer unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resultado", nullable = false)
    private ResultadoIAEntity resultado;

    // Relación con tabla intermedia
    @OneToMany(mappedBy = "parametroIA", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<ParametroCultivoIAEntity> parametrosCultivo;
}
