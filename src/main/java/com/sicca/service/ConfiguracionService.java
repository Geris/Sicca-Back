package com.sicca.service;

import com.sicca.dto.requests.perfil.ConfiguracionRequest;
import com.sicca.dto.requests.perfil.ConfiguracionTipoRequest;
import com.sicca.dto.responses.perfil.ConfiguracionResponse;
import com.sicca.dto.responses.perfil.ConfiguracionTipoResponse;
import com.sicca.model.perfil.ConfiguracionEntity;
import com.sicca.model.perfil.ConfiguracionTipoEntity;
import com.sicca.repository.ConfiguracionRepository;
import com.sicca.repository.ConfiguracionTipoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConfiguracionService {

    private final ConfiguracionRepository configuracionRepository;
    private final ConfiguracionTipoRepository configuracionTipoRepository;
    private final ModelMapper mapper;

    public ConfiguracionResponse agregar(ConfiguracionRequest dto) {
        ConfiguracionEntity entity = mapper.map(dto, ConfiguracionEntity.class);
        return mapper.map(configuracionRepository.save(entity), ConfiguracionResponse.class);
    }

    public List<ConfiguracionResponse> obtenerConfiguracionPorPerfilId(Integer perfilId) {
        return configuracionRepository.findByPerfilId(perfilId).stream()
                .map(entity -> mapper.map(entity, ConfiguracionResponse.class)).collect(Collectors.toList());
    }

    public ConfiguracionTipoResponse crearTipo(ConfiguracionTipoRequest dto) {
        ConfiguracionTipoEntity entity = mapper.map(dto, ConfiguracionTipoEntity.class);
        return mapper.map(configuracionTipoRepository.save(entity), ConfiguracionTipoResponse.class);
    }
}
