package com.sicca.repository;

import com.sicca.model.perfil.ConfiguracionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepository extends JpaRepository<ConfiguracionEntity, Long> {
}
