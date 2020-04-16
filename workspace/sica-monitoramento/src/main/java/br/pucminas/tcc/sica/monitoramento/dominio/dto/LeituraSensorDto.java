package br.pucminas.tcc.sica.monitoramento.dominio.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.*;

/**
 * Representa uma informação de leitura recebida de um sensor de barragem.
 * 
 * @author Thiago Colbert
 */
public class LeituraSensorDto implements Serializable {

    private static final long serialVersionUID = -7713733118520523370L;

    private String idHardwareSensor;
    private double variacao;
    private LocalDateTime dataHora;

    public LeituraSensorDto(String idHardwareSensor, double variacao, LocalDateTime dataHora) {
        this.idHardwareSensor = idHardwareSensor;
        this.variacao = variacao;
        this.dataHora = dataHora;
    }

    public LeituraSensorDto() {
        this(null, 0.0, null);
    }

    public String getIdHardwareSensor() {
        return idHardwareSensor;
    }

    public void setIdHardwareSensor(String idHardwareSensor) {
        this.idHardwareSensor = idHardwareSensor;
    }

    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("idHardwareSensor", idHardwareSensor)
                .append("variacao", variacao)
                .append("dataHora", dataHora)
                .toString();
    }
}
