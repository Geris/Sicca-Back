package com.sicca.dto.requests.cultivo;

import com.sicca.enums.EspecieCultivo;
import com.sicca.enums.TipoCultivo;
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
    private Integer especieId;
    private Integer invernaderoId;
}
