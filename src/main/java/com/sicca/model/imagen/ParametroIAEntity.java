package com.sicca.model.imagen;

import com.sicca.model.ParametroTipoEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    private ParametroTipoEntity tipoParametro;


}
