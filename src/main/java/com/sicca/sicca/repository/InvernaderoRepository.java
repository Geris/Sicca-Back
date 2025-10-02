package com.sicca.repository;

import com.sicca.model.invernadero.InvernaderoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvernaderoRepository extends JpaRepository<InvernaderoEntity, Long> {

    List<InvernaderoEntity> findByPerfilId(Long perfilId);
}
