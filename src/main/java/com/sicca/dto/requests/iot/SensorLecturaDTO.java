package com.sicca.dto.requests.iot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorLecturaDTO {
    private String id;     // p.ej. "luz-ambient", "temp-ambient", "humedad-1"
    private Double valor;  // lectura numérica

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}
