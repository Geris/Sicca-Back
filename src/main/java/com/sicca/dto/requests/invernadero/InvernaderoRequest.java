package com.sicca.dto.requests.invernadero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvernaderoRequest {
    private String nombre;
    private String ubicacion;
    private Integer perfilId;
}
