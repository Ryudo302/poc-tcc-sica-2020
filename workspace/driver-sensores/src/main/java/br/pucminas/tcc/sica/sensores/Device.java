package br.pucminas.tcc.sica.sensores;

import org.apache.commons.lang3.builder.*;

public class Device {

    private final String id;
    private final SensorType sensorType;

    public Device(String id, SensorType sensorType) {
        this.id = id;
        this.sensorType = sensorType;
    }

    public String getId() {
        return id;
    }

    public SensorType getSensorType() {
        return sensorType;
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
                .toString();
    }
}
