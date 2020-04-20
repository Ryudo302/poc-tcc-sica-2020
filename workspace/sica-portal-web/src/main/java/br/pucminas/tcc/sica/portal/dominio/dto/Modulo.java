package br.pucminas.tcc.sica.portal.dominio.dto;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.*;

public class Modulo {

    private String id;
    private String nome;
    private String url;

    public Modulo(String id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    Modulo() {
        this(null, null, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null
                && ClassUtils.isAssignable(obj.getClass(), Modulo.class)
                && new EqualsBuilder().append(id, ((Modulo) obj).id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
