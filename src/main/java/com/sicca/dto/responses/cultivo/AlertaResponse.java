package com.sicca.dto.responses.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaResponse {
    private Integer id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String severidad;
    private AlertaTipoResponse alertaTipo;
    private Integer cultivoId;
}
