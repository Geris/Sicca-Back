package com.sicca.repository;

import com.sicca.model.cultivo.EstadoCrecimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCrecimientoRepository extends JpaRepository<EstadoCrecimientoEntity, Integer> {
}
