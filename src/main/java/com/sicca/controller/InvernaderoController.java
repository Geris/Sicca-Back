package com.sicca.controller;

import com.sicca.dto.requests.invernadero.InvernaderoRequest;
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
    public List<InvernaderoRequest> listar() {
        return service.listar();
    }

    @GetMapping("/perfil")
    public List<InvernaderoRequest> obtenerPorPerfilId(@RequestParam Long perfilId) {
        return service.obtenerPorPerfilId(perfilId);
    }


    @GetMapping("/{id}")
    public InvernaderoRequest obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public InvernaderoRequest crear(@RequestBody InvernaderoRequest dto) {
        return service.crear(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
