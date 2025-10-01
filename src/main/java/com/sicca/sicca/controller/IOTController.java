package com.sicca.controller;
import com.sicca.dto.sensor.SensorDTO;
import com.sicca.dto.sensor.SensorLecturaDTO;
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
    public List<SensorDTO> listarSensores() {
        return service.listarSensores();
    }

    @PostMapping("/sensores")
    public SensorDTO crearSensor(@RequestBody SensorDTO dto) {
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
