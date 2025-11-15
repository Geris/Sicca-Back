package com.sicca.service;

import com.sicca.model.iot.EstadoControlEquipoEntity;
import com.sicca.repository.EstadoControlEquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ControlService {

    private final EstadoControlEquipoRepository repo;

    private EstadoControlEquipoEntity getOrCreate(String equipoSerial) {
        return repo.findByEquipoSerial(equipoSerial)
                .orElseGet(() -> {
                    EstadoControlEquipoEntity nuevo = new EstadoControlEquipoEntity();
                    nuevo.setEquipoSerial(equipoSerial);
                    nuevo.setPump1(false);
                    nuevo.setPump2(false);
                    nuevo.setPump3(false);
                    nuevo.setPump4(false);
                    nuevo.setLuz(false);
                    nuevo.setVent(false);
                    nuevo.setUpdatedAt(LocalDateTime.now());
                    return repo.save(nuevo);
                });
    }

    public EstadoControlEquipoEntity obtenerEstado(String equipoSerial) {
        return getOrCreate(equipoSerial);
    }

    public EstadoControlEquipoEntity actualizarPumps(String equipoSerial, int[] pumps) {
        EstadoControlEquipoEntity e = getOrCreate(equipoSerial);
        if (pumps != null && pumps.length >= 4) {
            e.setPump1(pumps[0] != 0);
            e.setPump2(pumps[1] != 0);
            e.setPump3(pumps[2] != 0);
            e.setPump4(pumps[3] != 0);
        }
        e.setUpdatedAt(LocalDateTime.now());
        return repo.save(e);
    }

    public EstadoControlEquipoEntity actualizarEnv(String equipoSerial, int luz, int vent) {
        EstadoControlEquipoEntity e = getOrCreate(equipoSerial);
        e.setLuz(luz != 0);
        e.setVent(vent != 0);
        e.setUpdatedAt(LocalDateTime.now());
        return repo.save(e);
    }
}
