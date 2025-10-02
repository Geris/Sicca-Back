package com.sicca.repository;

import com.sicca.model.invernadero.EstadoInvernaderoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoInvernaderoRepository extends JpaRepository<EstadoInvernaderoEntity, Long> {
}
