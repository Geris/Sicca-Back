package com.sicca.repository;

import com.sicca.model.cultivo.EspecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<EspecieEntity, Long> {
}
