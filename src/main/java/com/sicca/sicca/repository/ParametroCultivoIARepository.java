package com.sicca.repository;

import com.sicca.model.ParametroCultivoIAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParametroCultivoIARepository extends JpaRepository<ParametroCultivoIAEntity, Long> {
}
