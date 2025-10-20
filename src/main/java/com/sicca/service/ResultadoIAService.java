package com.sicca.service;

import com.sicca.model.ParametroTipoEntity;
import com.sicca.model.imagen.ImagenEntity;
import com.sicca.model.imagen.ParametroIAEntity;
import com.sicca.model.imagen.ResultadoIAEntity;
import com.sicca.repository.ImagenRepository;
import com.sicca.repository.ParametroTipoRepository;
import com.sicca.repository.ResultadoIARepository;
import com.sicca.service.ia.PythonAnalisysResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultadoIAService {

    private final ResultadoIARepository resultadoIARepository;
    private final ImagenRepository imagenRepository;
    private final ParametroTipoRepository parametroTipoRepository;

    public ResultadoIAEntity guardar(PythonAnalisysResponse dto, Integer idImagen) {

        ImagenEntity imagen = imagenRepository.findById(idImagen)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagen no encontrada"));

        ResultadoIAEntity resultado = ResultadoIAEntity.builder()
                .estadoSalud(dto.getEstadoSalud())
                .diagnostico(dto.getNombreCientifico())
                .recomendacion(String.join(" | ", dto.getRecomendaciones()))
                .imagen(imagen)
                .build();

        // Crear lista de parámetros
        List<ParametroIAEntity> parametros = new ArrayList<>();

        // Buscar tipos (pueden estar precargados en la tabla parametro_tipo)
        ParametroTipoEntity tipoTemp = parametroTipoRepository.findByNombre("Temperatura")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo 'Temperatura' no encontrado"));
        ParametroTipoEntity tipoHum = parametroTipoRepository.findByNombre("Humedad")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo 'Humedad' no encontrado"));
        ParametroTipoEntity tipoLuz = parametroTipoRepository.findByNombre("Luz")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo 'Luz' no encontrado"));

        parametros.add(new ParametroIAEntity(null, dto.getTemperatura().doubleValue(), 1, resultado, tipoTemp));
        parametros.add(new ParametroIAEntity(null, dto.getHumedad().doubleValue(), 2, resultado, tipoHum));
        parametros.add(new ParametroIAEntity(null, dto.getHorasLuz().doubleValue(), 3, resultado, tipoLuz));

        resultado.setParametrosIA(parametros);

        return resultadoIARepository.save(resultado);
    }
}

