package com.sicca.repository;

import com.sicca.model.iot.EstadoControlEquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoControlEquipoRepository extends JpaRepository<EstadoControlEquipoEntity, Long> {

    Optional<EstadoControlEquipoEntity> findByEquipoSerial(String equipoSerial);
}
