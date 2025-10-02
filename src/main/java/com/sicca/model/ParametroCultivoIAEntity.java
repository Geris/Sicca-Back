package com.sicca.model;

import com.sicca.model.cultivo.ParametroCultivoEntity;
import com.sicca.model.imagen.ParametroIAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parametro_cultivo_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametroCultivoIAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parametro_ia_id", nullable = false)
    private ParametroIAEntity parametroIA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parametro_cultivo_id", nullable = false)
    private ParametroCultivoEntity parametroCultivo;
}
