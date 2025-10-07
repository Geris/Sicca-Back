package com.sicca.repository;

import com.sicca.model.imagen.ResultadoIAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoIARepository extends JpaRepository<ResultadoIAEntity, Integer> {
}
