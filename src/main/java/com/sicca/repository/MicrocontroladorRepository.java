package com.sicca.repository;

import com.sicca.model.iot.MicrocontroladorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrocontroladorRepository extends JpaRepository<MicrocontroladorEntity, Long> {
}
