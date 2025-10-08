package com.sicca.repository;

import com.sicca.dto.requests.perfil.ConfiguracionRequest;
import com.sicca.model.perfil.ConfiguracionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionRepository extends JpaRepository<ConfiguracionEntity, Integer> {

    List<ConfiguracionEntity> findByPerfilId(Integer perfilId);
}
