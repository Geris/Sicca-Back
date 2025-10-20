package com.sicca.repository;

import com.sicca.model.ParametroTipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametroTipoRepository extends JpaRepository<ParametroTipoEntity, Integer> {
    Optional<ParametroTipoEntity> findByNombre(String nombre);
}
