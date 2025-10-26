package com.sicca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/control")
public class ControlController {

    static class EstadoControl {
        public int[] pumps = new int[]{0,0,0,0};
        public int luz = 0;
        public int vent = 0;
    }

    private final Map<String, EstadoControl> estadoPorEquipo = new ConcurrentHashMap<>();

    private EstadoControl ensure(String equipo) {
        return estadoPorEquipo.computeIfAbsent(equipo, k -> new EstadoControl());
    }

    // GET leído por el ESP-01 cada ~2s
    @GetMapping
    public ResponseEntity<?> getEstado(@RequestParam String equipo) {
        EstadoControl e = ensure(equipo);
        System.out.println("[GET /api/control] equipo=" + equipo +
                " -> pumps=["+e.pumps[0]+","+e.pumps[1]+","+e.pumps[2]+","+e.pumps[3]+"]" +
                " env(luz="+e.luz+", vent="+e.vent+")");
        return ResponseEntity.ok(Map.of(
                "pumps", e.pumps,
                "env", Map.of("luz", e.luz, "vent", e.vent)
        ));
    }

    // POST para setear bombas desde Postman
    @PostMapping("/pumps")
    public ResponseEntity<?> setPumps(@RequestParam String equipo, @RequestBody Map<String, Object> body) {
        var e = ensure(equipo);
        Object arr = body.get("pumps");
        if (!(arr instanceof java.util.List<?> list) || list.size() != 4) {
            System.out.println("[POST /pumps] equipo=" + equipo + " -> ERROR body=" + body);
            return ResponseEntity.badRequest().body("Debe enviar {\"pumps\":[x,y,z,w]} con 4 valores 0/1");
        }

        for (int i = 0; i < 4; i++) {
            Object v = list.get(i);
            int val = (v instanceof Number n) ? n.intValue() : Integer.parseInt(v.toString());
            e.pumps[i] = (val != 0) ? 1 : 0;
        }
        System.out.println("[POST /pumps] equipo=" + equipo +
                " -> OK pumps=["+e.pumps[0]+","+e.pumps[1]+","+e.pumps[2]+","+e.pumps[3]+"]");
        return ResponseEntity.ok(Map.of("pumps", e.pumps));
    }

    // POST para setear luz/ventilación desde Postman
    @PostMapping("/env")
    public ResponseEntity<?> setEnv(@RequestParam String equipo, @RequestBody Map<String, Object> body) {
        var e = ensure(equipo);

        Object luzObj = body.get("luz");
        Object ventObj = body.get("vent");
        if (luzObj == null || ventObj == null) {
            System.out.println("[POST /env] equipo=" + equipo + " -> ERROR body=" + body);
            return ResponseEntity.badRequest().body("Debe enviar {\"luz\":0|1, \"vent\":0|1}");
        }

        int luz  = (luzObj  instanceof Boolean bLuz)  ? (bLuz  ? 1 : 0) : Integer.parseInt(luzObj.toString());
        int vent = (ventObj instanceof Boolean bVent) ? (bVent ? 1 : 0) : Integer.parseInt(ventObj.toString());

        e.luz = luz;
        e.vent = vent;

        System.out.println("[POST /env] equipo=" + equipo +
                " -> OK env(luz="+e.luz+", vent="+e.vent+")");
        return ResponseEntity.ok(Map.of("env", Map.of("luz", e.luz, "vent", e.vent)));
    }
}
