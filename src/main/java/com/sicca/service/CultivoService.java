package com.sicca.service;


import com.sicca.dto.cultivo.CultivoDTO;
import com.sicca.dto.imagen.ImagenDTO;
import com.sicca.dto.imagen.ResultadoIADTO;
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

    public List<CultivoDTO> listar() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, CultivoDTO.class))
                .collect(Collectors.toList());
    }

    public CultivoDTO crear(CultivoDTO dto) {
        CultivoEntity entity = mapper.map(dto, CultivoEntity.class);
        return mapper.map(repository.save(entity), CultivoDTO.class);
    }

    public CultivoDTO obtenerPorId(Integer id) {
        Optional<CultivoEntity> entity = repository.findById(Long.valueOf(id));
        if(entity.isPresent()){
            return mapper.map(entity, CultivoDTO.class);
        }
        return new CultivoDTO();
    }

    public ImagenDTO analizarImagen(Integer cultivoId, MultipartFile file) {
        ResultadoIADTO resultadoAnalisis = analizarImagenUseCase.execute(file);
        ImagenDTO imagenDTO = ImagenDTO.builder()
                .ruta("ruta generica")
                .fechaCaptura(LocalDateTime.now())
                .resultadoIA(resultadoAnalisis)
                .cultivoId(cultivoId)
                .build();
        return imagenDTO;
    }
}

