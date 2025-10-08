package com.sicca.configuration;

import com.sicca.dto.requests.invernadero.InvernaderoRequest;
import com.sicca.model.invernadero.InvernaderoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(InvernaderoRequest.class, InvernaderoEntity.class)
                .addMappings(mapper -> mapper.skip(InvernaderoEntity::setId));

        return modelMapper;
    }
}

