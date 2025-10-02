package com.sicca.service;

import com.sicca.model.iot.DatoSensorEntity;
import com.sicca.repository.DatoSensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatoSensorServiceImpl implements DatoSensorService {

    private final DatoSensorRepository repository;

    public DatoSensorServiceImpl(DatoSensorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(DatoSensorEntity dato) {
        repository.save(dato);
    }

    @Override
    public List<DatoSensorEntity> listarTodos() {
        return repository.findAll();
    }
}
