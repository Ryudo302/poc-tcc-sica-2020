package br.pucminas.tcc.sica.sensores;

import org.apache.commons.lang3.builder.*;

public class Device {

    private final String id;
    private final SensorType sensorType;
    private boolean debug;

    public Device(String id, SensorType sensorType, boolean debug) {
        this.id = id;
        this.sensorType = sensorType;
        this.debug = debug;
    }

    public Device(String id, SensorType sensorType) {
        this(id, sensorType, false);
    }

    public String getId() {
        return id;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && Device.class.isAssignableFrom(obj.getClass())
                && new EqualsBuilder().append(id, ((Device) obj).id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("sensorType", sensorType)
                .append("debug", debug)
                .toString();
    }
}
