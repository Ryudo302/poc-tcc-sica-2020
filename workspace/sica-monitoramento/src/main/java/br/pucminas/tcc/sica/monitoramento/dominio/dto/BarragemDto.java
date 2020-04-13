package br.pucminas.tcc.sica.monitoramento.dominio.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.NivelEmergencia;

public class BarragemDto {

    @JsonProperty(access = Access.READ_ONLY)
    private Integer id;
    @JsonProperty(access = Access.READ_ONLY)
    private String nome;
    @JsonProperty(access = Access.READ_ONLY)
    private Integer capacidadeTotal;
    @JsonProperty(access = Access.READ_ONLY)
    private Integer alturaMacico;
    @JsonProperty(access = Access.READ_ONLY)
    private Double volume;
    @JsonProperty(access = Access.READ_ONLY)
    private NivelEmergencia nivelEmergencia;
    @JsonProperty(access = Access.READ_ONLY)
    private Long idAtivo;
    @JsonProperty(access = Access.READ_ONLY)
    private Set<SensorDto> sensores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Integer getAlturaMacico() {
        return alturaMacico;
    }

    public void setAlturaMacico(Integer alturaMacico) {
        this.alturaMacico = alturaMacico;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public NivelEmergencia getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(NivelEmergencia nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }

    public Long getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(Long idAtivo) {
        this.idAtivo = idAtivo;
    }

    public Set<SensorDto> getSensores() {
        return sensores;
    }

    public void setSensores(Set<SensorDto> sensores) {
        this.sensores = sensores;
    }
}
