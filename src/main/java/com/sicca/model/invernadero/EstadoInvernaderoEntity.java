package com.sicca.model.invernadero;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_invernadero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoInvernaderoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;
}
