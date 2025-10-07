package com.sicca.service;

import com.sicca.dto.requests.invernadero.InvernaderoRequest;
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

    public List<InvernaderoRequest> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, InvernaderoRequest.class))
                .collect(Collectors.toList());
    }

    public InvernaderoRequest obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(e -> mapper.map(e, InvernaderoRequest.class))
                .orElse(null);
    }

    public InvernaderoRequest crear(InvernaderoRequest dto) {
        InvernaderoEntity entity = mapper.map(dto, InvernaderoEntity.class);
        return mapper.map(repository.save(entity), InvernaderoRequest.class);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public List<InvernaderoRequest> obtenerPorPerfilId(Long perfilId) {
        List<InvernaderoEntity> invernaderoEntities = repository.findByPerfilId(perfilId);
        return invernaderoEntities.stream()
                .map(entity -> mapper.map(entity, InvernaderoRequest.class))
                .collect(Collectors.toList());
    }
}

