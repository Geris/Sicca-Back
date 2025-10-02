package com.sicca.service;

import com.sicca.model.iot.DatoSensorEntity;

import java.util.List;

public interface DatoSensorService {
    void guardar(DatoSensorEntity dato);
    List<DatoSensorEntity> listarTodos();
}
