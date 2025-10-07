package com.sicca.controller;

import com.sicca.dto.requests.iot.ComandoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/control")
public class ControlController {

    private ComandoRequest ultimoComando = new ComandoRequest(); // estado actual

    @PostMapping
    public ResponseEntity<String> recibirComando(@RequestBody ComandoRequest comando) {
        this.ultimoComando = comando;
        System.out.println("Nuevo comando recibido:");
        System.out.println("Luz: " + comando.isLuz());
        System.out.println("Riego: " + comando.isRiego());
        System.out.println("Ventilación: " + comando.isVentilacion());
        return ResponseEntity.ok("Comando actualizado");
    }

    @GetMapping
    public ComandoRequest enviarComando() {
        return ultimoComando;
    }
}
