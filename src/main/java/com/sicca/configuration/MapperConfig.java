package com.sicca.configuration;

import com.sicca.dto.requests.cultivo.CultivoRequest;
import com.sicca.dto.requests.invernadero.InvernaderoRequest;
import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.cultivo.EspecieEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}

