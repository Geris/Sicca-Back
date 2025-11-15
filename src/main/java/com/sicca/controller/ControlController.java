package com.sicca.controller;

import com.sicca.model.iot.EstadoControlEquipoEntity;
import com.sicca.service.ControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/control")
@RequiredArgsConstructor
public class ControlController {

    private final ControlService controlService;

    // =========================
    //  GET leído por el ESP-01 cada ~2s
    //  GET /api/control?equipo=ESP8266-XXXXXX
    // =========================
    @GetMapping
    public ResponseEntity<?> getEstado(@RequestParam String equipo) {
        EstadoControlEquipoEntity e = controlService.obtenerEstado(equipo);

        int[] pumps = new int[]{
                e.isPump1() ? 1 : 0,
                e.isPump2() ? 1 : 0,
                e.isPump3() ? 1 : 0,
                e.isPump4() ? 1 : 0
        };
        int luz  = e.isLuz()  ? 1 : 0;
        int vent = e.isVent() ? 1 : 0;

        System.out.println("[GET /api/control] equipo=" + equipo +
                " -> pumps=["+pumps[0]+","+pumps[1]+","+pumps[2]+","+pumps[3]+"]" +
                " env(luz="+luz+", vent="+vent+")");

        return ResponseEntity.ok(Map.of(
                "pumps", pumps,
                "env", Map.of("luz", luz, "vent", vent)
        ));
    }

    // =========================
    //  POST /api/control/pumps
    //  body: { "pumps":[x,y,z,w] }
    // =========================
    @PostMapping("/pumps")
    public ResponseEntity<?> setPumps(@RequestParam String equipo, @RequestBody Map<String, Object> body) {

        Object arr = body.get("pumps");
        if (!(arr instanceof java.util.List<?> list) || list.size() != 4) {
            System.out.println("[POST /pumps] equipo=" + equipo + " -> ERROR body=" + body);
            return ResponseEntity.badRequest()
                    .body("Debe enviar {\"pumps\":[x,y,z,w]} con 4 valores 0/1");
        }

        int[] pumps = new int[4];
        for (int i = 0; i < 4; i++) {
            Object v = list.get(i);
            int val = (v instanceof Number n) ? n.intValue()
                    : Integer.parseInt(v.toString());
            pumps[i] = (val != 0) ? 1 : 0;
        }

        EstadoControlEquipoEntity e = controlService.actualizarPumps(equipo, pumps);

        System.out.println("[POST /pumps] equipo=" + equipo +
                " -> OK pumps=["+pumps[0]+","+pumps[1]+","+pumps[2]+","+pumps[3]+"]");

        int[] resp = new int[]{
                e.isPump1() ? 1 : 0,
                e.isPump2() ? 1 : 0,
                e.isPump3() ? 1 : 0,
                e.isPump4() ? 1 : 0
        };
        return ResponseEntity.ok(Map.of("pumps", resp));
    }

    // =========================
    //  POST /api/control/env
    //  body: { "luz":0|1|true|false, "vent":0|1|true|false }
    // =========================
    @PostMapping("/env")
    public ResponseEntity<?> setEnv(@RequestParam String equipo, @RequestBody Map<String, Object> body) {

        Object luzObj  = body.get("luz");
        Object ventObj = body.get("vent");
        if (luzObj == null || ventObj == null) {
            System.out.println("[POST /env] equipo=" + equipo + " -> ERROR body=" + body);
            return ResponseEntity.badRequest()
                    .body("Debe enviar {\"luz\":0|1, \"vent\":0|1}");
        }

        int luz  = (luzObj  instanceof Boolean bLuz)  ? (bLuz  ? 1 : 0)
                : Integer.parseInt(luzObj.toString());
        int vent = (ventObj instanceof Boolean bVent) ? (bVent ? 1 : 0)
                : Integer.parseInt(ventObj.toString());

        EstadoControlEquipoEntity e = controlService.actualizarEnv(equipo, luz, vent);

        int luzResp  = e.isLuz()  ? 1 : 0;
        int ventResp = e.isVent() ? 1 : 0;

        System.out.println("[POST /env] equipo=" + equipo +
                " -> OK env(luz="+luzResp+", vent="+ventResp+")");

        return ResponseEntity.ok(
                Map.of("env", Map.of("luz", luzResp, "vent", ventResp))
        );
    }
}
