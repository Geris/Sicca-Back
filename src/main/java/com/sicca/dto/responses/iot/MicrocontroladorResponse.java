package com.sicca.dto.responses.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MicrocontroladorResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String codigoSerial;
}
