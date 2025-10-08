package com.sicca.controller;

import com.sicca.dto.requests.invernadero.InvernaderoRequest;
import com.sicca.dto.responses.invernadero.EstadoInvernaderoResponse;
import com.sicca.dto.responses.invernadero.InvernaderoResponse;
import com.sicca.enums.EstadoInvernadero;
import com.sicca.service.InvernaderoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invernadero")
@AllArgsConstructor
public class InvernaderoController {

    private final InvernaderoService service;

    @GetMapping("/perfil")
    public ResponseEntity<List<InvernaderoResponse>> obtenerPorPerfilId(@RequestParam Integer perfilId) {
        return ResponseEntity.ok(service.obtenerPorPerfilId(perfilId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvernaderoResponse> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<InvernaderoResponse> crear(@RequestBody InvernaderoRequest dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/estado")
    public ResponseEntity<EstadoInvernaderoResponse> crearEstadoInvernadero(@RequestParam EstadoInvernadero estado){
        return ResponseEntity.ok(service.crearEstadoInvernadero(estado));
    }
}
