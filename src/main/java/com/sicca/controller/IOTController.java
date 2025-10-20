package com.sicca.controller;

import com.sicca.dto.requests.iot.SensorLecturaDTO;
import com.sicca.dto.requests.iot.SensorRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.sicca.service.IOTService;
import java.util.List;

@RestController
@RequestMapping("/api/iot")
@AllArgsConstructor
public class IOTController {

    private final IOTService service;


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
