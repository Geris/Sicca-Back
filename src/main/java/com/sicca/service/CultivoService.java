package com.sicca.service;


import com.sicca.dto.requests.cultivo.CultivoRequest;
import com.sicca.dto.requests.imagen.ImagenRequest;
import com.sicca.dto.requests.imagen.ResultadoIARequest;
import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.repository.CultivoRepository;
import com.sicca.usecase.AnalizarImagenUseCase;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CultivoService {

    private final CultivoRepository repository;
    private final ModelMapper mapper;
    private final AnalizarImagenUseCase analizarImagenUseCase;

    public List<CultivoRequest> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, CultivoRequest.class))
                .collect(Collectors.toList());
    }

    public CultivoRequest crear(CultivoRequest dto) {
        CultivoEntity entity = mapper.map(dto, CultivoEntity.class);
        return mapper.map(repository.save(entity), CultivoRequest.class);
    }

    public CultivoRequest obtenerPorId(Integer id) {
        Optional<CultivoEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            return mapper.map(entity, CultivoRequest.class);
        }
        return new CultivoRequest();
    }

    public ImagenRequest analizarImagen(Integer cultivoId, MultipartFile file) {
        ResultadoIARequest resultadoAnalisis = analizarImagenUseCase.execute(file);
        ImagenRequest imagenDTO = ImagenRequest.builder()
                .ruta("ruta generica")
                .fechaCaptura(LocalDateTime.now())
                .cultivoId(cultivoId)
                .build();
        return imagenDTO;
    }
}

