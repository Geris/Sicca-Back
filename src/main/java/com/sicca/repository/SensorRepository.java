package com.sicca.repository;

import com.sicca.model.sensor.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Integer> {
    Optional<SensorEntity> findByCodigoSerial(String serial);

    List<SensorEntity> findByMicrocontroladorId(Integer microcontroladorId);
}
