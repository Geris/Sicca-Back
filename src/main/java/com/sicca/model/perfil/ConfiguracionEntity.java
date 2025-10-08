package com.sicca.model.perfil;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "configuracion_perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_configuracion_tipo", nullable = false)
    private ConfiguracionTipoEntity configuracionTipo;
}
