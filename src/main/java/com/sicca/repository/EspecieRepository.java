package com.sicca.repository;

import com.sicca.enums.EspecieCultivo;
import com.sicca.model.cultivo.EspecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<EspecieEntity, Integer> {
    Optional<EspecieEntity> findByNombre(String especie);
}
