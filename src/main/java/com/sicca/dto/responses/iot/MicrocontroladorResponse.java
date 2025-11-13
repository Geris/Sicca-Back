package com.sicca.dto.responses.iot;

import com.sicca.dto.responses.invernadero.InvernaderoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MicrocontroladorResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String codigoSerial;
    private List<SensorResponse> sensorList;
    private InvernaderoResponse invernaderoResponse;
}
