package com.sicca.service;



import com.sicca.dto.requests.perfil.PerfilRequest;
import com.sicca.model.perfil.PerfilEntity;
import com.sicca.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;
    private final ModelMapper mapper;

    public List<PerfilRequest> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, PerfilRequest.class))
                .collect(Collectors.toList());
    }

    public PerfilRequest crear(PerfilRequest dto) {
        PerfilEntity entity = mapper.map(dto, PerfilEntity.class);
        return mapper.map(repository.save(entity), PerfilRequest.class);
    }

    public PerfilRequest login(String email, String password) {
        Optional<PerfilEntity> optionalPerfilEntity = repository.findByEmailAndPassword(email, password);
        if(optionalPerfilEntity.isPresent()){
            return mapper.map(optionalPerfilEntity.get(), PerfilRequest.class);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
    }
}

