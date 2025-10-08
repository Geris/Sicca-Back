package com.sicca.dto.requests.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaRequest {
    private String descripcion;
    private LocalDateTime fechaHora;
    private String severidad;
    private AlertaTipoRequest alertaTipo;
    private Integer cultivoId;
}
