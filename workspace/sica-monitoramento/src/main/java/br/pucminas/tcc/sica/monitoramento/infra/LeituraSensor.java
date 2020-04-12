package br.pucminas.tcc.sica.monitoramento.infra;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class LeituraSensor implements Serializable {

    private static final long serialVersionUID = -7713733118520523370L;

    private final String idHardwareSensor;
    private final double variacao;
    private final LocalDateTime dataHora;

    public LeituraSensor(String idHardwareSensor, double variacao, LocalDateTime dataHora) {
        Objects.requireNonNull(idHardwareSensor, "idHardwareSensor");
        Objects.requireNonNull(dataHora, "dataHora");

        this.idHardwareSensor = idHardwareSensor;
        this.variacao = variacao;
        this.dataHora = dataHora;
    }

    public String getIdHardwareSensor() {
        return idHardwareSensor;
    }

    public double getVariacao() {
        return variacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
