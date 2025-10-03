package com.sicca.service;

import com.sicca.dto.invernadero.InvernaderoDTO;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.repository.InvernaderoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvernaderoService {

    private final InvernaderoRepository repository;
    private final ModelMapper mapper;

    public List<InvernaderoDTO> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, InvernaderoDTO.class))
                .collect(Collectors.toList());
    }

    public InvernaderoDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.map(e, InvernaderoDTO.class))
                .orElse(null);
    }

    public InvernaderoDTO crear(InvernaderoDTO dto) {
        InvernaderoEntity entity = mapper.map(dto, InvernaderoEntity.class);
        return mapper.map(repository.save(entity), InvernaderoDTO.class);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<InvernaderoDTO> obtenerPorPerfilId(Long perfilId) {
        List<InvernaderoEntity> invernaderoEntities = repository.findByPerfilId(perfilId);
        return invernaderoEntities.stream()
                .map(entity -> mapper.map(entity, InvernaderoDTO.class))
                .collect(Collectors.toList());
    }
}

