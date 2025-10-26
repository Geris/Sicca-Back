package com.sicca.controller;

import com.sicca.dto.requests.cultivo.CultivoRequest;
import com.sicca.dto.requests.cultivo.EspecieRequest;
import com.sicca.dto.requests.iot.MicrocontroladorRequest;
import com.sicca.dto.responses.cultivo.CultivoResponse;
import com.sicca.dto.responses.cultivo.EspecieResponse;
import com.sicca.dto.responses.imagen.ImagenResponse;
import com.sicca.dto.responses.imagen.ResultadoIAResponse;
import com.sicca.service.CultivoService;
import com.sicca.service.storage.GcsStorageService;
import com.sicca.service.ia.PythonAnalyzerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/cultivo")
@AllArgsConstructor
@Slf4j
public class CultivoController {

    private final CultivoService service;
    private final GcsStorageService storageService;
    private final PythonAnalyzerService analyzerService;

    @GetMapping
    @Operation(summary = "Obtener un cultivo por id")
    public ResponseEntity<CultivoResponse> obtenerPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<CultivoResponse> crear(@RequestBody CultivoRequest dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping(value = "/obtenerPorInvernadero")
    @Operation(summary = "Obtener los cultivos para un invernadero")
    public ResponseEntity<List<CultivoResponse>> obtenerPorInvernaderoId(@RequestParam Integer id) {
        return ResponseEntity.ok(service.obtenerPorInvernaderoId(id));
    }

    @PostMapping(value = "/imagen", consumes = "multipart/form-data")
    @Operation(summary = "Subir imagen a cloud storage")
    public ResponseEntity<ImagenResponse> subirImagen(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("cultivoId") Integer cultivoId) {
        return ResponseEntity.ok(service.subirImagen(file, cultivoId));
    }

    @PostMapping(value = "/analizar")
    @Operation(summary = "Analizar imagen almacenada en cloud storage")
    public ResponseEntity<ResultadoIAResponse> analyze(@RequestParam("imagenId") Integer imagenId) {
        return ResponseEntity.ok(service.analizar(imagenId));
    }

    @PostMapping(value = "/enlazar")
    @Operation(summary = "Enlaza un cultivo con un microcontrolador")
    public ResponseEntity<Void> analyze(@RequestParam("cultivoId") Integer cultivoId,
                                        @RequestParam("microcontroladorId") Integer microcontroladorId) {
        service.enlazarMicrocontrolador(cultivoId, microcontroladorId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/especie")
    public ResponseEntity<EspecieResponse> crearEspecie(@RequestBody EspecieRequest especie){
        return ResponseEntity.ok(service.crearEspecieCultivo(especie));
    }
}

