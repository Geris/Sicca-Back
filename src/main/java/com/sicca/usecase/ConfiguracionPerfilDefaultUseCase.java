package com.sicca.usecase;

import com.sicca.model.perfil.ConfiguracionEntity;
import com.sicca.model.perfil.ConfiguracionTipoEntity;
import com.sicca.model.perfil.PerfilEntity;
import com.sicca.repository.ConfiguracionRepository;
import com.sicca.repository.ConfiguracionTipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ConfiguracionPerfilDefaultUseCase {

    private final ConfiguracionRepository configuracionRepository;
    private final ConfiguracionTipoRepository configuracionTipoRepository;

    public void execute(PerfilEntity perfilEntity){
        List<ConfiguracionTipoEntity> configuracionesDefault = configuracionTipoRepository.findAll();

        configuracionesDefault.forEach(tipo -> {
            ConfiguracionEntity configuracionEntity = ConfiguracionEntity.builder()
                    .configuracionTipo(tipo)
                    .valor("")
                    .perfil(perfilEntity)
                    .build();
            configuracionRepository.save(configuracionEntity);
        });
    }
}
