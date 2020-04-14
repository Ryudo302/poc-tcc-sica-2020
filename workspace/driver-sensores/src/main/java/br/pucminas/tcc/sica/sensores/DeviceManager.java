package br.pucminas.tcc.sica.sensores;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DeviceManager {

    private static final DeviceManager INSTANCE = new DeviceManager();

    private final List<Device> devices;
    private final SensorEventListeners listeners;
    private final Simulator simulator;

    private DeviceManager() {
        devices = new ArrayList<>();
        devices.add(new Device("desl001", SensorType.DISPLACEMENT));
        devices.add(new Device("desl002", SensorType.DISPLACEMENT));
        devices.add(new Device("incl001", SensorType.INCLINATION));
        devices.add(new Device("incl002", SensorType.INCLINATION));
        devices.add(new Device("nvla001", SensorType.WATER_LEVEL));
        devices.add(new Device("nvla002", SensorType.WATER_LEVEL));
        devices.add(new Device("pres001", SensorType.PRESSURE));
        devices.add(new Device("pres002", SensorType.PRESSURE));

        listeners = new SensorEventListeners();
        simulator = new Simulator(devices, listeners).start();
    }

    public static DeviceManager getInstance() {
        return INSTANCE;
    }

    public List<Device> getAllDevices() {
        return Collections.unmodifiableList(devices);
    }

    public List<Device> getDevices(SensorType tipo) {
        return devices
                .stream()
                .filter(Device -> Device.getSensorType().equals(tipo))
                .collect(Collectors.toList());
    }

    public boolean registerListener(DeviceEventListener listener, SensorType sensorType) {
        return listeners.add(listener, sensorType);
    }

    public boolean unregisterListener(DeviceEventListener listener, SensorType sensorType) {
        return listeners.remove(listener, sensorType);
    }

    public void shutdown() {
        simulator.stop();
    }

    static final class Simulator {

        private final ExecutorService threadPool;
        private final List<Device> devices;
        private final SensorEventListeners listeners;

        private boolean active;

        public Simulator(List<Device> devices, SensorEventListeners listeners) {
            this.devices = devices;
            this.listeners = listeners;
            this.threadPool = Executors.newFixedThreadPool(devices.size());
            this.active = true;
        }

        public void stop() {
            this.active = false;
            this.threadPool.shutdown();
        }

        public Simulator start() {
            devices.stream().forEach(device -> {
                threadPool.execute(() -> {

                    long delayInicial = (long) (Math.random() * 2000);
                    try {
                        Thread.sleep(delayInicial);
                    } catch (InterruptedException exception) {
                        System.err.println("Erro ao executar delay inicial: " + exception);
                        exception.printStackTrace();
                    }

                    while (active) {
                        try {
                            double value = (Math.random() * 2) * (Math.random() < 0.5 ? 1 : -1);
                            listeners.fireEvent(new DeviceEvent(device, LocalDateTime.now(), value), device.getSensorType());
                            Thread.sleep(2000L);
                        } catch (InterruptedException exception) {
                            System.err.println("Erro na execução do simulador: " + exception);
                            exception.printStackTrace();
                        }
                    }
                });
            });

            return this;
        }
    }
}
