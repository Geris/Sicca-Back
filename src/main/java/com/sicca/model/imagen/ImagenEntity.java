package com.sicca.model.imagen;

import com.sicca.model.cultivo.CultivoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "imagen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String ruta;

    @Column(name = "fecha_captura", nullable = false)
    private LocalDateTime fechaCaptura;

    private Integer resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultivo", nullable = false)
    private CultivoEntity cultivo;

    @OneToOne(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private ResultadoIAEntity resultadoIA;
}
