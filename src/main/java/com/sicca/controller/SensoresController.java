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
    @Operation(summary = "Crea un microcontrolador para un invernadero")
    public ResponseEntity<MicrocontroladorResponse> crearMicrocontrolador(@RequestParam("invernaderoId") Integer invernaderoId,
                                                                @RequestBody MicrocontroladorRequest microcontrolador) {

        return ResponseEntity.ok(sensorService.crearMicrocontrolador(invernaderoId, microcontrolador));
    }

    @GetMapping(value = "/obtenerMicros")
    @Operation(summary = "Obtiene una lista de los microcontroladores")
    public ResponseEntity<List<MicrocontroladorResponse>> obtenerMicrocontroladores() {

        return ResponseEntity.ok(sensorService.obtenerMicrocontroladores());
    }

    @GetMapping(value = "/obtenerSensoresPorMicro")
    @Operation(summary = "Obtiene una lista de los sensores para un microcontrolador")
    public ResponseEntity<List<SensorResponse>> obtenerSensoresPorMicro(@RequestParam("microcontroladorId") Integer microcontroladorId) {

        return ResponseEntity.ok(sensorService.obtenerSensoresPorMicrocontroladorId(microcontroladorId));
    }

    @GetMapping(value = "/obtenerSensoresPorCultivo")
    @Operation(summary = "Obtiene una lista de los sensores para un cultivo")
    public ResponseEntity<List<SensorResponse>> obtenerSensoresPorCultivo(@RequestParam("cultivoId") Integer cultivoId) {

        return ResponseEntity.ok(sensorService.obtenerSensoresPorCultivoId(cultivoId));
    }

    @GetMapping(value = "/obtenerLecturas")
    @Operation(summary = "Obtiene una lista de las lecturas para un sensor")
    public ResponseEntity<List<SensorLecturaResponse>> obtenerLecturas(@RequestParam("sensorId") Integer sensorId) {

        return ResponseEntity.ok(sensorService.obtenerLecturas(sensorId));
    }

    @GetMapping(value = "/obtenerUltimaLectura")
    @Operation(summary = "Obtiene la ultima lectura para un sensor")
    public ResponseEntity<SensorLecturaResponse> obtenerUltimLectura(@RequestParam("sensorId") Integer sensorId) {

        return ResponseEntity.ok(sensorService.obtenerUltimaLectura(sensorId));
    }

    @PostMapping(value = "/crearSensorMicro")
    @Operation(summary = "Crea un sensor para un microcontrolador")
    public ResponseEntity<SensorResponse> crearSensorMicro(@RequestParam("microcontroladorId") Integer microcontroladorId,
                                                      @RequestBody SensorRequest sensor) {

        return ResponseEntity.ok(sensorService.crearSensorMicro(microcontroladorId, sensor));
    }

    @PostMapping(value = "/crearSensorCultivo")
    @Operation(summary = "Crea un sensor para un cultivo")
    public ResponseEntity<SensorResponse> crearSensorCultivo(@RequestParam("cultivoId") Integer cultivoId,
                                                      @RequestBody SensorRequest sensor) {

        return ResponseEntity.ok(sensorService.crearSensorCultivo(cultivoId, sensor));
    }
}
