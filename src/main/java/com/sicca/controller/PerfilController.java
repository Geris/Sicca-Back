package com.sicca.controller;

import com.sicca.dto.perfil.PerfilDTO;
import com.sicca.service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfil")
@AllArgsConstructor
public class PerfilController {

    private final PerfilService service;

    @GetMapping
    public List<PerfilDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public PerfilDTO crear(@RequestBody PerfilDTO dto) {
        return service.crear(dto);
    }
}

