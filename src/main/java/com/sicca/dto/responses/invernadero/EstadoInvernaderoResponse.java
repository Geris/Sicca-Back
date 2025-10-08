package com.sicca.dto.responses.invernadero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoInvernaderoResponse {
    private Integer id;
    private String nombre;
}
