package com.sicca.service;

import com.sicca.dto.requests.iot.MedicionPayloadDTO;
import com.sicca.dto.requests.iot.MicrocontroladorRequest;
import com.sicca.dto.requests.iot.SensorLecturaDTO;
import com.sicca.dto.requests.iot.SensorRequest;
import com.sicca.dto.responses.iot.MicrocontroladorResponse;
import com.sicca.dto.responses.iot.SensorLecturaResponse;
import com.sicca.dto.responses.iot.SensorResponse;
import com.sicca.enums.TipoSensor;
import com.sicca.model.cultivo.CultivoEntity;
import com.sicca.model.invernadero.InvernaderoEntity;
import com.sicca.model.iot.MicrocontroladorEntity;
import com.sicca.model.sensor.SensorEntity;
import com.sicca.model.sensor.SensorLecturaEntity;
import com.sicca.model.sensor.TipoSensorEntity;
import com.sicca.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorLecturaRepository sensorLecturaRepository;
    private final TipoSensorRepository tipoSensorRepository;
    private final MicrocontroladorRepository microcontroladorRepository;
    private final CultivoRepository cultivoRepository;
    private final InvernaderoRepository invernaderoRepository;

    public String crearLectura(MedicionPayloadDTO payload) {

        System.out.println();
        log.error("====== LECTURAS RECIBIDAS ======");
        log.error("Equipo: {}", payload.getEquipoSerial());
        log.error("Fecha : {}", payload.getTimestamp());

        List<SensorLecturaDTO> sensores = payload.getSensores();
        if (sensores.isEmpty()) {
            return "Sin lecturas en el arreglo 'sensores'.";
        }

        for (SensorLecturaDTO sensor : sensores) {
            crear(sensor);
        }
        return "OK";
    }

    private void crear(SensorLecturaDTO sensor) {
        Optional<SensorEntity> sensorEntity = sensorRepository.findByCodigoSerial(sensor.getId());

        if(sensorEntity.isEmpty()){
            log.error("No se encontro el sensor {}", sensor.getId());
            return;
        }
        SensorLecturaEntity lectura = SensorLecturaEntity.builder()
                .fechaMedicion(LocalDateTime.now())
                .valor(sensor.getValor())
                .nombre(sensor.getId())
                .sensor(sensorEntity.get())
                .build();
        sensorLecturaRepository.save(lectura);
    }

    public SensorResponse crearSensorMicro(Integer microcontroladorId, SensorRequest sensor) {
        TipoSensorEntity tipoSensor = tipoSensorRepository.findByNombre(TipoSensor.SENSOR.getValor());
        Optional<MicrocontroladorEntity> microcontrolador = microcontroladorRepository.findById(Long.valueOf(microcontroladorId));
        if(microcontrolador.isEmpty()){
            throw new NoSuchElementException("No se encontro el microcontrolador");
        }

        SensorEntity sensorEntity = SensorEntity.builder()
                .codigoSerial(sensor.getCodigoSerial())
                .descripcion(sensor.getDescripcion())
                .tipo(tipoSensor)
                .microcontrolador(microcontrolador.get())
                .unidadMedida(1)
                .build();
        SensorEntity savedSensor = sensorRepository.save(sensorEntity);

        return mapSensor(savedSensor);
    }

    public SensorResponse crearSensorCultivo(Integer sensorId, SensorRequest sensor) {
        TipoSensorEntity tipoSensor = tipoSensorRepository.findByNombre(TipoSensor.SENSOR.getValor());
        Optional<CultivoEntity> cultivo = cultivoRepository.findById(sensorId);
        if(cultivo.isEmpty()){
            throw new NoSuchElementException("No se encontro el microcontrolador");
        }

        SensorEntity sensorEntity = SensorEntity.builder()
                .codigoSerial(sensor.getCodigoSerial())
                .descripcion(sensor.getDescripcion())
                .tipo(tipoSensor)
                .cultivo(cultivo.get())
                .unidadMedida(1)
                .build();
        SensorEntity savedSensor = sensorRepository.save(sensorEntity);

        return mapSensor(savedSensor);
    }

    public MicrocontroladorResponse crearMicrocontrolador(Integer invernaderoId, MicrocontroladorRequest microcontrolador) {
        Optional<InvernaderoEntity> invernaderoOpt = invernaderoRepository.findById(invernaderoId);
        if(invernaderoOpt.isEmpty()){
            throw new NoSuchElementException("No se encontro el invernadero");
        }

        MicrocontroladorEntity entity = MicrocontroladorEntity.builder()
                .codigoSerial(microcontrolador.getCodigoSerial())
                .descripcion(microcontrolador.getDescripcion())
                .nombre(microcontrolador.getDescripcion())
                .invernadero(invernaderoOpt.get())
                .build();
        MicrocontroladorEntity savedEntity = microcontroladorRepository.save(entity);

        List<CultivoEntity> cultivoEntities = cultivoRepository.findByInvernaderoId(invernaderoId);
        cultivoEntities.forEach(cultivoEntity -> {
            cultivoEntity.setMicrocontrolador(savedEntity);
            cultivoRepository.save(cultivoEntity);
        });
        return mapMicrocontrolador(savedEntity);
    }

    public List<MicrocontroladorResponse> obtenerMicrocontroladores() {
        List<MicrocontroladorEntity> entities = microcontroladorRepository.findAll();
        return entities.stream()
                .map(this::mapMicrocontrolador).toList();
    }

    public List<SensorResponse> obtenerSensoresPorMicrocontroladorId(Integer microcontroladorId) {
        List<SensorEntity> sensores = sensorRepository.findByMicrocontroladorId(microcontroladorId);
        return sensores.stream()
                .map(this::mapSensor).toList();
    }

    public List<SensorResponse> obtenerSensoresPorCultivoId(Integer cultivoId) {
        List<SensorEntity> sensores = sensorRepository.findByCultivoId(cultivoId);
        return sensores.stream()
                .map(this::mapSensor).toList();
    }

    public List<SensorLecturaResponse> obtenerLecturas(Integer sensorId) {
        List<SensorLecturaEntity> entities = sensorLecturaRepository.findBySensorId(sensorId);
        return entities.stream().map(this::mapLectura).toList();
    }

    public MicrocontroladorResponse mapMicrocontrolador(MicrocontroladorEntity entity){
        return MicrocontroladorResponse.builder()
                .id(entity.getId())
                .codigoSerial(entity.getCodigoSerial())
                .descripcion(entity.getDescripcion())
                .nombre(entity.getNombre())
                .build();
    }

    private SensorResponse mapSensor(SensorEntity entity){
        return SensorResponse.builder()
                .id(entity.getId())
                .codigoSerial(entity.getCodigoSerial())
                .microcontroladorId(entity.getMicrocontrolador() != null ? entity.getMicrocontrolador().getId() : null)
                .cultivoId(entity.getCultivo() != null ? entity.getCultivo().getId() : null)
                .unidadMedida(1)
                .descripcion(entity.getDescripcion())
                .build();
    }

    private SensorLecturaResponse mapLectura(SensorLecturaEntity entity){
        return SensorLecturaResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .sensorId(entity.getSensor().getId())
                .fechaMedicion(entity.getFechaMedicion())
                .valor(entity.getValor())
                .build();
    }
}
