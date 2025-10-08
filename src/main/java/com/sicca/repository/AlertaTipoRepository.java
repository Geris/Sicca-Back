package com.sicca.repository;

import com.sicca.model.cultivo.AlertaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaTipoRepository extends JpaRepository<AlertaTipo, Integer> {
}
