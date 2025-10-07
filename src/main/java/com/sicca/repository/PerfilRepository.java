package com.sicca.repository;

import com.sicca.model.perfil.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Integer> {
    Optional<PerfilEntity> findByEmailAndPassword(String email, String password);
}
