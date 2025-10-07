package com.sicca.repository;

import com.sicca.model.perfil.EstadoPerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPerfilRepository extends JpaRepository<EstadoPerfilEntity, Integer> {
}
