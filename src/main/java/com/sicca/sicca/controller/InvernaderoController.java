package com.sicca.controller;

import com.sicca.dto.invernadero.InvernaderoDTO;
import com.sicca.service.InvernaderoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invernadero")
@AllArgsConstructor
public class InvernaderoController {

    private final InvernaderoService service;

    @GetMapping
    public List<InvernaderoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/perfil")
    public List<InvernaderoDTO> obtenerPorPerfilId(@RequestParam Long perfilId) {
        return service.obtenerPorPerfilId(perfilId);
    }


    @GetMapping("/{id}")
    public InvernaderoDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public InvernaderoDTO crear(@RequestBody InvernaderoDTO dto) {
        return service.crear(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
