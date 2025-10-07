package com.sicca.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroTipoResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
}
