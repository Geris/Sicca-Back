package com.sicca.dto.responses.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenResponse {
    private Integer id;
    private String ruta;
    private LocalDateTime fechaCaptura;
    private Integer cultivoId;
    private Integer resultadoIAId;
}
