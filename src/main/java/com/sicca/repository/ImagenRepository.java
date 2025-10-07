package com.sicca.repository;

import com.sicca.model.imagen.ImagenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Integer> {
}
