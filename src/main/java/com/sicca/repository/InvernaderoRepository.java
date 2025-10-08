package com.sicca.repository;

import com.sicca.model.invernadero.InvernaderoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvernaderoRepository extends JpaRepository<InvernaderoEntity, Integer> {
    List<InvernaderoEntity> findByPerfilId(Integer perfilId);
}
