package com.sicca.repository;

import com.sicca.model.perfil.ConfiguracionTipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionTipoRepository extends JpaRepository<ConfiguracionTipoEntity, Integer> {
}
