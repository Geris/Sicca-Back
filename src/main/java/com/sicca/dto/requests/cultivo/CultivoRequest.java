package com.sicca.dto.requests.cultivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultivoRequest {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private String tipo;
    private String severidad;
    private Integer especieId;
    private Integer invernaderoId;
    private Integer parametroCultivoId;
    private Integer alertasId;
    private Integer imagenesId;
    private Integer microcontroladorId;
}
