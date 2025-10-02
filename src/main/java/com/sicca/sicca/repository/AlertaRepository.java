package com.sicca.repository;


import com.sicca.model.cultivo.AlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<AlertaEntity, Long> {
}
