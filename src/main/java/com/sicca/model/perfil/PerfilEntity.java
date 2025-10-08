package com.sicca.model.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 50)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 50)
    private String telefono;

    @CreatedDate
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @LastModifiedDate
    @Column(name = "ultima_modificacion")
    private LocalDateTime ultimaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    private EstadoPerfilEntity estado;
}
