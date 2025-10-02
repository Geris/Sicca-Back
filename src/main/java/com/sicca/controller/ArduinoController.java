package com.sicca.controller;

import com.sicca.dto.iot.DatoSensorDTO;
import com.sicca.model.iot.DatoSensorEntity;
import com.sicca.service.DatoSensorService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class ArduinoController {

    private final DatoSensorService service;

    public ArduinoController(DatoSensorService service) {
        this.service = service;
    }

    @PostMapping
    public String recibirSensores(@RequestBody List<DatoSensorDTO> datos) {
        for (DatoSensorDTO dto : datos) {
            DatoSensorEntity entidad = new DatoSensorEntity();
            entidad.setSensorId(dto.getId());
            entidad.setValor(dto.getValor());
            entidad.setTimestamp(LocalDateTime.parse(dto.getTimestamp()));

            service.guardar(entidad);
        }

        return "Datos recibidos correctamente";
    }

    @GetMapping
    public List<DatoSensorEntity> listarTodos() {
        return service.listarTodos();
    }
}
