package com.sicca.model.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoPerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;
}
