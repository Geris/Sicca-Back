package com.sicca.model.cultivo;

import com.sicca.model.ParametroTipoEntity;
import com.sicca.model.invernadero.EstadoInvernaderoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "parametro_cultivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametroCultivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "unidad_medida")
    private Integer unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultivo")
    private CultivoEntity cultivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    private ParametroTipoEntity tipoParametro;
}
