package com.sicca.controller;

import com.sicca.dto.requests.cultivo.CultivoRequest;
import com.sicca.dto.requests.imagen.ImagenRequest;
import com.sicca.service.CultivoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cultivo")
@AllArgsConstructor
public class CultivoController {

    private final CultivoService service;

    @GetMapping
    @Operation(summary = "Obtener un cultivo por id")
    public CultivoRequest obtenerPorId(@RequestParam Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public CultivoRequest crear(@RequestBody CultivoRequest dto) {
        return service.crear(dto);
    }

    @PostMapping(value = "/imagen", consumes = "multipart/form-data")
    public ImagenRequest analizarImagen(@RequestParam("cultivoId") Integer cultivoId,
                                        @RequestParam("file") MultipartFile file) {
        return service.analizarImagen(cultivoId, file);
    }
}

