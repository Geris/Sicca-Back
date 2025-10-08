package com.sicca.repository;

import com.sicca.model.sensor.TipoSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSensorRepository extends JpaRepository<TipoSensorEntity, Integer> {
}
