package br.pucminas.tcc.sica.sensores;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DeviceManagerTest {

    public static void main(String[] args) throws InterruptedException {
        DeviceManager deviceManager = DeviceManager.getInstance();

        Arrays.stream(SensorType.values()).forEach(type -> {
            deviceManager.registerListener(event -> {
                double value = event.getValue();
                System.out.println(MessageFormat.format("[{0}]\t{1} at {2}:\t{3}", event.getDevice().getSensorType(), event.getDevice().getId(),
                        event.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), (value >= 0 ? "+" : "") + value));
            }, type);
        });

        Thread.sleep(5000L);

        deviceManager.shutdown();
    }
}
