package com.sicca.controller;

import com.sicca.dto.requests.iot.SensorRequest;
import com.sicca.dto.requests.iot.SensorLecturaDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.sicca.service.IOTService;
import java.util.List;

@RestController
@RequestMapping("/api/iot")
@AllArgsConstructor
public class IOTController {

    private final IOTService service;

    // Sensores
    @GetMapping("/sensores")
    public List<SensorRequest> listarSensores() {
        return service.listarSensores();
    }

    @PostMapping("/sensores")
    public SensorRequest crearSensor(@RequestBody SensorRequest dto) {
        return service.crearSensor(dto);
    }

    // Lecturas
    @GetMapping("/lecturas")
    public List<SensorLecturaDTO> listarLecturas() {
        return service.listarLecturas();
    }

    @PostMapping("/lecturas")
    public SensorLecturaDTO registrarLectura(@RequestBody SensorLecturaDTO dto) {
        return service.registrarLectura(dto);
    }
}
