package com.sicca.dto.requests.iot;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MedicionPayloadDTO {
    private String equipoSerial;          // p.ej. "ESP8266-ABC123"
    private String timestamp;             // ISO-8601: "2025-09-22T22:41:00"
    private List<SensorLecturaDTO> sensores; // lista de {id, valor}

}
