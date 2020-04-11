package br.pucminas.tcc.sica.monitoramento.infra;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.sensores.*;

@Component
public class StartupListener {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        Arrays.stream(SensorType.values()).forEach(type -> {
            deviceManager.registerListener(deviceEvent -> {
                double value = deviceEvent.getValue();
                System.out.println(MessageFormat.format("[{0}]\t{1} at {2}:\t{3}", deviceEvent.getDevice().getSensorType(), deviceEvent.getDevice().getId(),
                        deviceEvent.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), (value >= 0 ? "+" : "") + value));
            }, type);
        });
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        DeviceManager.getInstance().shutdown();
    }
}
