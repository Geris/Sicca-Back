package com.sicca.model.imagen;

import com.sicca.model.cultivo.CultivoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "imagen")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String ruta;

    @CreatedDate
    @Column(name = "fecha_captura", nullable = false)
    private LocalDateTime fechaCaptura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultivo", nullable = false)
    private CultivoEntity cultivo;

    @OneToOne(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private ResultadoIAEntity resultadoIA;
}
