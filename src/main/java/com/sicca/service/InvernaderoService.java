package com.sicca.service;

import com.sicca.dto.requests.invernadero.InvernaderoRequest;
import com.sicca.dto.responses.invernadero.EstadoInvernaderoResponse;
import com.sicca.dto.responses.invernadero.InvernaderoResponse;
import com.sicca.dto.responses.iot.MicrocontroladorResponse;
import com.sicca.enums.EstadoInvernadero;
import com.sicca.model.invernadero.EstadoInvernaderoEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.model.perfil.PerfilEntity;
import com.sicca.repository.EstadoInvernaderoRepository;
import com.sicca.repository.InvernaderoRepository;
import com.sicca.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvernaderoService {

    private final InvernaderoRepository repository;
    private final EstadoInvernaderoRepository estadoInvernaderoRepository;
    private final PerfilRepository perfilRepository;
    private final ModelMapper mapper;

    public InvernaderoResponse obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::mapInvernadero)
                .orElse(null);
    }

    public InvernaderoResponse crear(InvernaderoRequest dto) {
        InvernaderoEntity entity = mapper.map(dto, InvernaderoEntity.class);

        EstadoInvernaderoEntity estadoInvernaderoEntity = estadoInvernaderoRepository.findByNombre(EstadoInvernadero.ACTIVO.getValor());
        entity.setEstado(estadoInvernaderoEntity);

        Optional<PerfilEntity> perfilEntity = perfilRepository.findById(dto.getPerfilId());
        perfilEntity.ifPresent(entity::setPerfil);

        InvernaderoEntity savedEntity = repository.save(entity);
        return mapInvernadero(savedEntity);
    }


    public List<InvernaderoResponse> obtenerPorPerfilId(Integer perfilId) {
        List<InvernaderoEntity> invernaderoEntities = repository.findByPerfilId(perfilId);
        return invernaderoEntities.stream()
                .map(this::mapInvernadero)
                .collect(Collectors.toList());
    }

    public EstadoInvernaderoResponse crearEstadoInvernadero(EstadoInvernadero estado) {
        EstadoInvernaderoEntity estadoEntity = EstadoInvernaderoEntity.builder()
                .nombre(estado.getValor())
                .build();
        return mapper.map(estadoInvernaderoRepository.save(estadoEntity), EstadoInvernaderoResponse.class);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private InvernaderoResponse mapInvernadero(InvernaderoEntity entity){
        return InvernaderoResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .ubicacion(entity.getUbicacion())
                .perfilId(entity.getPerfil().getId())
                .estadoId(entity.getEstado().getId())
                .fechaActualizacion(entity.getFechaActualizacion())
                .fechaCreacion(entity.getFechaCreacion())
                .microcontrolador(mapper.map(entity.getMicrocontrolador(), MicrocontroladorResponse.class))
                .build();
    }
}

