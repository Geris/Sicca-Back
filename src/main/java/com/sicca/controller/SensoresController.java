package com.sicca.controller;



import com.sicca.dto.requests.iot.MedicionPayloadDTO;
import com.sicca.dto.requests.iot.SensorLecturaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/sensores")
public class SensoresController {

    @PostMapping
    public ResponseEntity<String> recibir(@RequestBody MedicionPayloadDTO payload) {

        if (payload == null || payload.getEquipoSerial() == null || payload.getSensores() == null) {
            return ResponseEntity.badRequest().body("Payload inválido");
        }

        System.out.println();
        log.error("====== LECTURAS RECIBIDAS ======");
        log.error("Equipo: " + payload.getEquipoSerial());
        log.error("Fecha : " + payload.getTimestamp());

        List<SensorLecturaDTO> sensores = payload.getSensores();
        if (sensores.isEmpty()) {
            log.error("Sin lecturas en el arreglo 'sensores'.");
        } else {
            for (SensorLecturaDTO s : sensores) {
                String id = s.getId();
                Double v  = s.getValor();
                log.error(String.format(" - %-14s => %s", id, v));
            }
        }
        log.error("================================");
        System.out.println();

        return ResponseEntity.ok("OK");
    }
}
