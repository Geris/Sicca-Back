package com.sicca.dto.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaDTO {
    private Integer id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String tipo;
    private String severidad;
    private Integer cultivoId;
}

