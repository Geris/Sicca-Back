package com.sicca.controller;

import com.sicca.dto.cultivo.CultivoDTO;
import com.sicca.dto.imagen.ImagenDTO;
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
    public CultivoDTO obtenerPorId(@RequestParam Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public CultivoDTO crear(@RequestBody CultivoDTO dto) {
        return service.crear(dto);
    }

    @PostMapping(value = "/imagen", consumes = "multipart/form-data")
    public ImagenDTO analizarImagen(@RequestParam("cultivoId") Integer cultivoId,
                                    @RequestParam("file") MultipartFile file) {
        return service.analizarImagen(cultivoId, file);
    }
}

