package br.pucminas.tcc.sica.monitoramento.dominio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.TipoSensor;

public class SensorDto {

    @JsonProperty(access = Access.READ_ONLY)
    private Long id;
    @JsonProperty(access = Access.READ_ONLY)
    private String idHardware;
    @JsonProperty(access = Access.READ_ONLY)
    private TipoSensor tipo;
    @JsonProperty(access = Access.READ_ONLY)
    private Long idAtivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(String idHardware) {
        this.idHardware = idHardware;
    }

    public TipoSensor getTipo() {
        return tipo;
    }

    public void setTipo(TipoSensor tipo) {
        this.tipo = tipo;
    }

    public Long getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(Long idAtivo) {
        this.idAtivo = idAtivo;
    }
}
