package com.sicca.service;

import com.sicca.dto.requests.perfil.PerfilRequest;
import com.sicca.dto.responses.perfil.EstadoPerfilResponse;
import com.sicca.dto.responses.perfil.PerfilResponse;
import com.sicca.enums.EstadoPerfil;
import com.sicca.model.perfil.EstadoPerfilEntity;
import com.sicca.model.perfil.PerfilEntity;
import com.sicca.repository.EstadoPerfilRepository;
import com.sicca.repository.PerfilRepository;
import com.sicca.usecase.ConfiguracionPerfilDefaultUseCase;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;
    private final EstadoPerfilRepository estadoPerfilRepository;
    private final ConfiguracionPerfilDefaultUseCase configuracionPerfilDefaultUseCase;
    private final ModelMapper mapper;

    private static final String CREDENCIALES_INVALIDAS = "Credenciales inválidas";

    public PerfilResponse crear(PerfilRequest dto) {
        PerfilEntity entity = mapper.map(dto, PerfilEntity.class);
        EstadoPerfilEntity estadoPerfilEntity = estadoPerfilRepository.findByNombre(EstadoPerfil.ACTIVO.getValor());
        entity.setEstado(estadoPerfilEntity);

        PerfilEntity savedEntity = repository.save(entity);

        configuracionPerfilDefaultUseCase.execute(savedEntity);
        return mapper.map(savedEntity, PerfilResponse.class);
    }


    public PerfilResponse login(String email, String password) {
        Optional<PerfilEntity> optionalPerfilEntity = repository.findByEmailAndPassword(email, password);
        if(optionalPerfilEntity.isPresent()){
            return mapper.map(optionalPerfilEntity.get(), PerfilResponse.class);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, CREDENCIALES_INVALIDAS);
    }

    public EstadoPerfilResponse crearEstadoPerfil(EstadoPerfil estado) {
        EstadoPerfilEntity estadoPerfilEntity = EstadoPerfilEntity.builder()
                .nombre(estado.getValor())
                .build();
        return mapper.map(estadoPerfilRepository.save(estadoPerfilEntity), EstadoPerfilResponse.class);
    }

    public PerfilResponse cambiarEstadoPerfil(Integer perfilId, EstadoPerfil estado) {
        Optional<PerfilEntity> perfilOptional = repository.findById(perfilId);
        if(perfilOptional.isPresent()){
            EstadoPerfilEntity estadoEntity = estadoPerfilRepository.findByNombre(estado.getValor());
            PerfilEntity perfil = perfilOptional.get();
            perfil.setEstado(estadoEntity);
            return mapper.map(repository.save(perfil), PerfilResponse.class);
        }
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "El perfil no existe o el estado no es valido");
    }
}

