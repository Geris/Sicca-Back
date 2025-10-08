package com.sicca.controller;

import com.sicca.dto.requests.iot.DatoSensorRequest;
import com.sicca.model.iot.DatoSensorEntity;
import com.sicca.service.DatoSensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class ArduinoController {

    private final DatoSensorService service;

    public ArduinoController(DatoSensorService service) {
        this.service = service;
    }

    @PostMapping
    public String recibirSensores(@RequestBody List<DatoSensorRequest> datos) {
        return "Datos recibidos correctamente";
    }

    @GetMapping
    public List<DatoSensorEntity> listarTodos() {
        return service.listarTodos();
    }
}
