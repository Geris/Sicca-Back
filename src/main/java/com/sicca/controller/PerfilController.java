package com.sicca.controller;

import com.sicca.dto.requests.perfil.PerfilRequest;
import com.sicca.dto.responses.perfil.EstadoPerfilResponse;
import com.sicca.dto.responses.perfil.PerfilResponse;
import com.sicca.enums.EstadoPerfil;
import com.sicca.service.PerfilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfil")
@RequiredArgsConstructor
@Slf4j
public class PerfilController {

    private final PerfilService service;

    @PostMapping
    public ResponseEntity<PerfilResponse> crear(@RequestBody PerfilRequest dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<PerfilResponse> login(@RequestParam String usuario, @RequestParam String password){
        return ResponseEntity.ok(service.login(usuario, password));
    }

    @PostMapping(value = "/estado")
    public ResponseEntity<EstadoPerfilResponse> crearEstadoPerfil(@RequestParam EstadoPerfil estado){
        return ResponseEntity.ok(service.crearEstadoPerfil(estado));
    }

    @PutMapping(value = "/estado")
    public ResponseEntity<PerfilResponse> actualizarEstadoPerfil(@RequestParam Integer perfilId, @RequestParam EstadoPerfil estado){
        return ResponseEntity.ok(service.cambiarEstadoPerfil(perfilId, estado));
    }
}

