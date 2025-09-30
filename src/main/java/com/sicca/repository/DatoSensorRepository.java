package com.sicca.repository;

import com.sicca.model.iot.DatoSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoSensorRepository extends JpaRepository<DatoSensorEntity, Long> {
}
