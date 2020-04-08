package br.pucminas.tcc.sica.sensores;

import java.util.*;

import org.apache.commons.collections4.CollectionUtils;

public class SensorEventListeners {

    private final Map<SensorType, Set<DeviceEventListener>> sensorTypeListeners;

    public SensorEventListeners() {
        sensorTypeListeners = new HashMap<>();
    }

    public boolean add(DeviceEventListener listener, SensorType sensorType) {
        Objects.requireNonNull(listener, "listener");
        Objects.requireNonNull(sensorType, "sensorType");

        Set<DeviceEventListener> listeners = sensorTypeListeners.get(sensorType);
        if (listeners == null) {
            listeners = new HashSet<>();
        }

        boolean added = listeners.add(listener);
        sensorTypeListeners.put(sensorType, listeners);
        return added;
    }

    public boolean remove(DeviceEventListener listener, SensorType sensorType) {
        Objects.requireNonNull(listener, "listener");
        Objects.requireNonNull(sensorType, "sensorType");

        Set<DeviceEventListener> listeners = sensorTypeListeners.get(sensorType);
        if (CollectionUtils.isNotEmpty(listeners)) {
            return listeners.remove(listener);
        } else {
            return false;
        }
    }

    public void fireEvent(DeviceEvent event, SensorType sensorType) {
        Objects.requireNonNull(event, "event");
        Objects.requireNonNull(sensorType, "sensorType");

        Set<DeviceEventListener> listeners = sensorTypeListeners.get(sensorType);
        if (CollectionUtils.isNotEmpty(listeners)) {
            listeners.forEach(listener -> listener.onDeviceChange(event));
        }
    }
}
