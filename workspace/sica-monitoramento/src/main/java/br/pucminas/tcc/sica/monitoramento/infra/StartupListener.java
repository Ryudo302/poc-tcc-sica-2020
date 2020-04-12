package br.pucminas.tcc.sica.monitoramento.infra;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.sensores.*;

@Component
public class StartupListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

    @Autowired
    private SimpMessagingTemplate websocket;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        Arrays.stream(SensorType.values()).forEach(type -> {
            deviceManager.registerListener(deviceEvent -> {
                Device device = deviceEvent.getDevice();
                double value = deviceEvent.getValue();

                LOGGER.debug("Nova leitura recebida: [{}]\t{} @ {}:\t{}", device.getSensorType(), device.getId(),
                        deviceEvent.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), (value >= 0 ? "+" : "") + value);

                websocket.convertAndSend(WebSocketConfiguration.MESSAGE_PREFIX + "/sensor", new LeituraSensor(device.getId(), value, deviceEvent.getTimestamp()));
            }, type);
        });
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        DeviceManager.getInstance().shutdown();
    }
}
