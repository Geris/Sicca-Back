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
    private Long id;
    private String nombre;
    private String codigoSerial;
    private String descripcion;
    private Integer sensoresId;
}
