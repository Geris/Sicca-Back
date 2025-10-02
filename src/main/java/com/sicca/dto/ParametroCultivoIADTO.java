package com.sicca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroCultivoIADTO {
    private Long id;
    private String nombre;
    private String valorOptimo;
    private Long perfilId;
}
