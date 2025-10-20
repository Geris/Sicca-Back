package com.sicca.service.ia;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PythonAnalisysResponse {
    @JsonProperty("nombre_cientifico")
    private String nombreCientifico;

    @JsonProperty("estado_salud")
    private String estadoSalud;

    private List<String> recomendaciones;
    private Integer temperatura;
    private Integer humedad;

    @JsonProperty("horas_luz")
    private Integer horasLuz;
}