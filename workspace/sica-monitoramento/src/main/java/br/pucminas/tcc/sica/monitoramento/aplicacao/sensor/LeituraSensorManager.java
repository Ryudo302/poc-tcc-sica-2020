package br.pucminas.tcc.sica.monitoramento.aplicacao.sensor;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.annotation.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.LeituraSensorDto;
import br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper.LeituraSensorMapper;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.LeituraSensor;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.SensorRepository;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.LeituraSensorService;
import br.pucminas.tcc.sica.monitoramento.infra.WebSocketConfiguration;
import br.pucminas.tcc.sica.sensores.*;

@Component
public class LeituraSensorManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeituraSensorManager.class);

    @Autowired
    private SimpMessagingTemplate websocket;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private LeituraSensorService leituraSensorService;
    @Autowired
    private LeituraSensorMapper leituraSensorMapper;

    @PostConstruct
    protected void init() {
        DeviceManager deviceManager = DeviceManager.getInstance();

        Arrays.stream(SensorType.values()).forEach(type -> {
            deviceManager.registerListener(criarLeituraSensorListener(), type);
        });
    }

    private DeviceEventListener criarLeituraSensorListener() {
        return deviceEvent -> {
            Device device = deviceEvent.getDevice();
            double value = deviceEvent.getValue();

            LOGGER.debug("Nova leitura recebida: [{}]\t{} @ {}:\t{}", device.getSensorType(), device.getId(),
                    deviceEvent.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), (value >= 0 ? "+" : "") + value);

            LOGGER.debug("Salvando a última leitura do sensor: {}", device.getId());
            LeituraSensor leituraSensor = new LeituraSensor(device.getId(), value, deviceEvent.getTimestamp());
            leituraSensorService.salvar(leituraSensor);

            LeituraSensorDto leituraDto = leituraSensorMapper.converterLeituraSensorParaDto(leituraSensor);

            LOGGER.debug("Enviando via WebSockets a leitura do sensor: {}", leituraDto);
            websocket.convertAndSend(WebSocketConfiguration.MESSAGE_PREFIX + "/sensor", leituraDto);

            sensorRepository.findByIdHardware(leituraDto.getIdHardwareSensor())
                    .ifPresentOrElse(sensor -> leituraSensorService.atualizarNivelEmergencia(sensor.getBarragem(), sensor, leituraDto),
                            () -> LOGGER.warn("Ignorando sensor desconhecido: {}", leituraDto.getIdHardwareSensor()));
        };
    }

    @PreDestroy
    protected void destroy() {
        DeviceManager.getInstance().shutdown();
    }
}
