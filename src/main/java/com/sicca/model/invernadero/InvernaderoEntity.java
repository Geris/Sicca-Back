package com.sicca.model.invernadero;

import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.perfil.PerfilEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "fecha_registro")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "ultima_modificacion")
    private LocalDateTime fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    private EstadoInvernaderoEntity estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CultivoEntity> cultivos;
}
