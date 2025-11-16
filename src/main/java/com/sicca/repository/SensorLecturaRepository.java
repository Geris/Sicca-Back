package com.sicca.repository;

import com.sicca.model.sensor.SensorLecturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorLecturaRepository extends JpaRepository<SensorLecturaEntity, Integer> {
    List<SensorLecturaEntity> findBySensorId(Integer sensorId);
}
