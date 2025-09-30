package com.sicca.dto.invernadero;

import com.sicca.dto.cultivo.CultivoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvernaderoDTO {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private LocalDate fechaActualizacion;
    private LocalDate fechaCreacion;
    private Integer estadoId;
    private Integer perfilId;
    private List<CultivoDTO> cultivos;
}

