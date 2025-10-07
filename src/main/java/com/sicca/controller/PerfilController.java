package com.sicca.controller;

import com.sicca.dto.requests.perfil.PerfilRequest;
import com.sicca.service.PerfilService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfil")
@RequiredArgsConstructor
@Slf4j
public class PerfilController {

    private final PerfilService service;

    @GetMapping
    public List<PerfilRequest> listar() {
        log.error("listando....");
        return service.listar();
    }

    @PostMapping
    public PerfilRequest crear(@RequestBody PerfilRequest dto) {
        return service.crear(dto);
    }

    @PostMapping(value = "/login")
    public PerfilRequest login(String usuario, String password){
        return service.login(usuario, password);
    }


}

