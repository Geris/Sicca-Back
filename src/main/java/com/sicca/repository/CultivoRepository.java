package com.sicca.repository;

import com.sicca.model.cultivo.CultivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultivoRepository extends JpaRepository<CultivoEntity, Integer> {
    List<CultivoEntity> findByInvernaderoId(Integer invernaderoId);
}
