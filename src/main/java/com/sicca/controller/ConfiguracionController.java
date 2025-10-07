package com.sicca.controller;

import com.sicca.dto.requests.perfil.ConfiguracionRequest;
import com.sicca.dto.requests.perfil.ConfiguracionTipoRequest;
import com.sicca.dto.responses.perfil.ConfiguracionResponse;
import com.sicca.dto.responses.perfil.ConfiguracionTipoResponse;
import com.sicca.service.ConfiguracionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuracion")
@AllArgsConstructor
public class ConfiguracionController {

    private final ConfiguracionService configuracionService;

    @Operation(summary = "Agrega una nueva configuracion para un usuario")
    @PostMapping(value = "/agregar")
    public ResponseEntity<ConfiguracionResponse> agregarConfiguracion(@RequestBody ConfiguracionRequest dto) {
        return ResponseEntity.ok(configuracionService.agregar(dto));
    }

    @Operation(summary = "obtener las configuraciones de un usuario")
    @GetMapping(value = "/obtenerPorPerfil")
    public ResponseEntity<List<ConfiguracionResponse>> obtenerConfiguracionUsuario(@RequestParam Integer perfilId) {
        return ResponseEntity.ok(configuracionService.obtenerConfiguracionPorPerfilId(perfilId));
    }

    @Operation(summary = "Agrega una nuevo valor generico de configuracion")
    @PostMapping(value = "/crearTipo")
    public ResponseEntity<ConfiguracionTipoResponse> crearTipo(@RequestBody ConfiguracionTipoRequest dto) {
        return ResponseEntity.ok(configuracionService.crearTipo(dto));
    }
}
