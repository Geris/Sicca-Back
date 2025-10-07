package com.sicca.dto.requests.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenRequest {
    private String ruta;
    private LocalDateTime fechaCaptura;
    private Integer resultado;
    private Integer cultivoId;
    private Integer resultadoIAId;
}
