package com.sicca.model.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
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

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "ultima_modificacion")
    private LocalDateTime ultimaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    private EstadoPerfilEntity estado;
}
