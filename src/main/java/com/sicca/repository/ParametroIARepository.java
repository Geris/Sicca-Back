package com.sicca.repository;

import com.sicca.model.imagen.ParametroIAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroIARepository extends JpaRepository<ParametroIAEntity, Long> {
}
