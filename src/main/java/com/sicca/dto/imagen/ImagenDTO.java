package com.sicca.dto.imagen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenDTO {
    private Integer id;
    private String ruta;
    private LocalDateTime fechaCaptura;
    private Integer resultado;
    private Integer cultivoId;
    private ResultadoIADTO resultadoIA;
}
