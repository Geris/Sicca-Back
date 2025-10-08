package com.sicca.dto.requests.iot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MicrocontroladorRequest {
    private String nombre;
    private String codigoSerial;
    private String descripcion;
    private Integer sensoresId;
}
