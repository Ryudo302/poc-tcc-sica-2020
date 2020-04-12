package br.pucminas.tcc.sica.monitoramento.infra.persistencia;

import java.io.Serializable;

import org.apache.commons.lang3.builder.*;

public abstract class AbstractEntidade<ID extends Serializable> {

    public abstract ID getId();

    @Override
    public boolean equals(Object obj) {
        return obj != null && AbstractEntidade.class.isAssignableFrom(obj.getClass())
                && new EqualsBuilder().append(getId(), ((AbstractEntidade<?>) obj).getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", getId())
                .toString();
    }
}
