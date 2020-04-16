package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leitura_sensor")
public class LeituraSensor implements Serializable {

    private static final long serialVersionUID = -7713733118520523370L;

    @Id
    private String idHardwareSensor;
    private double variacao;
    private LocalDateTime dataHora;

    public LeituraSensor(String idHardwareSensor, double variacao, LocalDateTime dataHora) {
        this.idHardwareSensor = idHardwareSensor;
        this.variacao = variacao;
        this.dataHora = dataHora;
    }

    LeituraSensor() {
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
}
