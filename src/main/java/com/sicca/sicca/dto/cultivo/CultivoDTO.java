package com.sicca.dto.cultivo;

import com.sicca.dto.imagen.ImagenDTO;
import com.sicca.dto.sensor.SensorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultivoDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String tipo;
    private String severidad;
    private Integer especieId;
    private Integer estadoCrecimientoId;
    private Integer invernaderoId;
    private Integer parametroCultivoId;
    private List<AlertaDTO> alertas;
    private List<ImagenDTO> imagenes;
    private List<SensorDTO> sensores;
}
