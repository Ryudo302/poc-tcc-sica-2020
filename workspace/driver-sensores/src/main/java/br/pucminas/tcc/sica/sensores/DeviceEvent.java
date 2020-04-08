package br.pucminas.tcc.sica.sensores;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.*;

public class DeviceEvent {

    private final Device device;
    private final LocalDateTime timestamp;
    private final double value;

    public DeviceEvent(Device device, LocalDateTime timestamp, double value) {
        this.device = device;
        this.timestamp = timestamp;
        this.value = value;
    }

    public Device getDevice() {
        return device;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("device", device)
                .append("timestamp", timestamp)
                .append("value", value)
                .toString();
    }
}
