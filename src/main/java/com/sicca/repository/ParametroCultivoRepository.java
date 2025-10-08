package com.sicca.repository;

import com.sicca.model.cultivo.ParametroCultivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroCultivoRepository extends JpaRepository<ParametroCultivoEntity, Integer> {
}
