package com.sicca.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicca.dto.requests.cultivo.CultivoRequest;
import com.sicca.dto.requests.cultivo.EspecieRequest;
import com.sicca.dto.requests.iot.MicrocontroladorRequest;
import com.sicca.dto.responses.cultivo.CultivoResponse;
import com.sicca.dto.responses.cultivo.EspecieResponse;
import com.sicca.dto.responses.imagen.ImagenResponse;
import com.sicca.dto.responses.imagen.ResultadoIAResponse;
import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.cultivo.EspecieEntity;
import com.sicca.model.imagen.ImagenEntity;
import com.sicca.model.imagen.ResultadoIAEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.repository.*;
import com.sicca.service.ia.PythonAnalisysResponse;
import com.sicca.service.ia.PythonAnalyzerService;
import com.sicca.service.storage.GcsStorageService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CultivoService {

    private final CultivoRepository repository;
    private final InvernaderoRepository invernaderoRepository;
    private final EspecieRepository especieRepository;
    private final ImagenRepository imagenRepository;
    private final ModelMapper mapper;
    private final GcsStorageService storageService;
    private final PythonAnalyzerService analyzerService;
    private final ResultadoIAService resultadoIAService;
    private final ObjectMapper objectMapper;

    @Transactional
    public CultivoResponse crear(CultivoRequest dto) {
        InvernaderoEntity invernadero = invernaderoRepository.findById(dto.getInvernaderoId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "El invernadero no existe o el estado no es válido"));

        EspecieEntity especie = especieRepository.findById(dto.getEspecieId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "La especie no existe: " + dto.getEspecieId()));

        CultivoEntity cultivo = CultivoEntity.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .fechaInicio(dto.getFechaInicio() != null ? dto.getFechaInicio() : LocalDate.now())
                .fechaFin(dto.getFechaFin())
                .tipo(dto.getTipo())
                .especie(especie)
                .invernadero(invernadero)
                .build();

        CultivoEntity saved = repository.save(cultivo);
        return mapper.map(saved, CultivoResponse.class);
    }

    public CultivoResponse obtenerPorId(Integer id) {
        Optional<CultivoEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            return mapper.map(entity, CultivoResponse.class);
        }
        return new CultivoResponse();
    }

    public List<CultivoResponse> obtenerPorInvernaderoId(Integer invernaderoId) {
        List<CultivoResponse> responseList = new ArrayList<>();
        List<CultivoEntity> entityList = repository.findByInvernaderoId(invernaderoId);
        entityList.forEach(entity -> {
                    CultivoResponse cultivo = new CultivoResponse();
                    cultivo.setNombre(entity.getNombre());
                    cultivo.setDescripcion(entity.getDescripcion());
                    cultivo.setFechaInicio(entity.getFechaInicio());
                    cultivo.setFechaFin(entity.getFechaFin());
                    cultivo.setTipo(entity.getTipo());
                    cultivo.setInvernaderoId(entity.getInvernadero().getId());
                    cultivo.setEspecieId(entity.getEspecie().getId());
                    cultivo.setMicrocontroladorId(entity.getMicrocontrolador().getId());
                    responseList.add(cultivo);
                });
        return responseList;
    }


    public ResultadoIAResponse analizar(Integer imagenId) {
        Optional<ImagenEntity> imagenEntity = imagenRepository.findById(imagenId);
        if(imagenEntity.isPresent()){
            PythonAnalisysResponse analisysResponse = executeAnalisys(imagenEntity.get().getRuta());
            ResultadoIAEntity resultadoIAEntity = resultadoIAService.guardar(analisysResponse, imagenId);

            log.error("mapeando ResultadoIAEntity");
            return mapper.map(resultadoIAEntity, ResultadoIAResponse.class);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagen no encontrada");
    }

    private PythonAnalisysResponse executeAnalisys(String uri) {
        try {
            JsonNode analysis = analyzerService.analyzeImage(uri);
            return objectMapper.treeToValue(analysis, PythonAnalisysResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ImagenResponse subirImagen(MultipartFile file, Integer cultivoId) {
        try{
            String gsUri = storageService.uploadImage(file, Map.of("source", "sicca"));
            Optional<CultivoEntity> cultivo = repository.findById(cultivoId);
            if(cultivo.isPresent()){
                ImagenEntity imagenEntity = ImagenEntity.builder()
                        .ruta(gsUri)
                        .cultivo(cultivo.get())
                        .build();
                ImagenEntity savedImage = imagenRepository.save(imagenEntity);
                ImagenResponse response = mapper.map(savedImage, ImagenResponse.class);
                response.setCultivoId(cultivoId);
                return response;
            }
            throw new BadRequestException();
        }catch (IOException ioException){
            throw new RuntimeException(ioException.getMessage());
        }

    }

    public void enlazarMicrocontrolador(Integer cultivoId, MicrocontroladorRequest microcontrolador) {
        //TODO: implementar

    }

    public EspecieResponse crearEspecieCultivo(EspecieRequest especie) {
        EspecieEntity entity = EspecieEntity.builder()
                .nombre(especie.getNombre())
                .nombreCientifico(especie.getNombreCientifico())
                .build();
        return mapper.map(especieRepository.save(entity), EspecieResponse.class);
    }
}

