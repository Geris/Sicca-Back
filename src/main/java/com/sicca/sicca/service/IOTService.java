package com.sicca.service;

import com.sicca.dto.sensor.SensorDTO;
import com.sicca.dto.sensor.SensorLecturaDTO;
import com.sicca.model.sensor.SensorEntity;
import com.sicca.model.sensor.SensorLecturaEntity;
import com.sicca.repository.SensorLecturaRepository;
import com.sicca.repository.SensorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IOTService {

    private final SensorRepository sensorRepository;
    private final SensorLecturaRepository lecturaRepository;
    private final ModelMapper mapper;

    // Sensores
    public List<SensorDTO> listarSensores() {
        return sensorRepository.findAll().stream()
                .map(e -> mapper.map(e, SensorDTO.class))
                .collect(Collectors.toList());
    }

    public SensorDTO crearSensor(SensorDTO dto) {
        SensorEntity entity = mapper.map(dto, SensorEntity.class);
        return mapper.map(sensorRepository.save(entity), SensorDTO.class);
    }

    // Lecturas
    public List<SensorLecturaDTO> listarLecturas() {
        return lecturaRepository.findAll().stream()
                .map(e -> mapper.map(e, SensorLecturaDTO.class))
                .collect(Collectors.toList());
    }

    public SensorLecturaDTO registrarLectura(SensorLecturaDTO dto) {
        SensorLecturaEntity entity = mapper.map(dto, SensorLecturaEntity.class);
        return mapper.map(lecturaRepository.save(entity), SensorLecturaDTO.class);
    }
}

