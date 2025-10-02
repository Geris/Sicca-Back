package com.sicca.service;



import com.sicca.dto.perfil.PerfilDTO;
import com.sicca.model.perfil.PerfilEntity;
import com.sicca.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;
    private final ModelMapper mapper;

    public List<PerfilDTO> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, PerfilDTO.class))
                .collect(Collectors.toList());
    }

    public PerfilDTO crear(PerfilDTO dto) {
        PerfilEntity entity = mapper.map(dto, PerfilEntity.class);
        return mapper.map(repository.save(entity), PerfilDTO.class);
    }
}

