package com.sicca.controller;



import com.sicca.dto.requests.iot.MedicionPayloadDTO;
import com.sicca.dto.requests.iot.MicrocontroladorRequest;
import com.sicca.dto.requests.iot.SensorRequest;
import com.sicca.dto.responses.iot.MicrocontroladorResponse;
import com.sicca.dto.responses.iot.SensorLecturaResponse;
import com.sicca.dto.responses.iot.SensorResponse;
import com.sicca.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sensores")
public class SensoresController {

    private final SensorService sensorService;

    @PostMapping
    @Operation(summary = "Inserta una lectura de sensor")
    public ResponseEntity<String> recibir(@RequestBody MedicionPayloadDTO payload) {

        if (payload == null || payload.getEquipoSerial() == null || payload.getSensores() == null) {
            return ResponseEntity.badRequest().body("Payload inválido");
        }

        return ResponseEntity.ok(sensorService.crearLectura(payload));
    }

    @PostMapping(value = "/crearMicro")
    @Operation(summary = "Crea un microcontrolador para un cultivo")
    public ResponseEntity<MicrocontroladorResponse> crearMicrocontrolador(@RequestParam("cultivoId") Integer cultivoId,
                                                                @RequestBody MicrocontroladorRequest microcontrolador) {

        return ResponseEntity.ok(sensorService.crearMicrocontrolador(cultivoId, microcontrolador));
    }

    @GetMapping(value = "/obtenerMicros")
    @Operation(summary = "Obtiene una lista de los microcontroladores")
    public ResponseEntity<List<MicrocontroladorResponse>> obtenerMicrocontroladores() {

        return ResponseEntity.ok(sensorService.obtenerMicrocontroladores());
    }

    @GetMapping(value = "/obtenerSensores")
    @Operation(summary = "Obtiene una lista de los sensores para un microcontrolador")
    public ResponseEntity<List<SensorResponse>> obtenerSensores(@RequestParam("microcontroladorId") Integer microcontroladorId) {

        return ResponseEntity.ok(sensorService.obtenerSensoresPorMicrocontroladorId(microcontroladorId));
    }

    @GetMapping(value = "/obtenerLecturas")
    @Operation(summary = "Obtiene una lista de las lecturas para un sensor")
    public ResponseEntity<List<SensorLecturaResponse>> obtenerLecturas(@RequestParam("sensorId") Integer sensorId) {

        return ResponseEntity.ok(sensorService.obtenerLecturas(sensorId));
    }

    @PostMapping(value = "/crear")
    @Operation(summary = "Crea un sensor para un microcontrolador")
    public ResponseEntity<SensorResponse> crearSensor(@RequestParam("microcontroladorId") Integer microcontroladorId,
                                                      @RequestBody SensorRequest sensor) {

        return ResponseEntity.ok(sensorService.crearSensor(microcontroladorId, sensor));
    }
}
