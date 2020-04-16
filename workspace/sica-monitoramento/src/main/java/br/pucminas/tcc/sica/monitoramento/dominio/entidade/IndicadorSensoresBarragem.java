package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import java.util.Map;

import org.apache.commons.lang3.builder.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.BarragemSimpleDto;

/**
 * Representa uma informação da situação dos níveis de uma barragem, conforme grau de atenção.
 * 
 * @author Thiago Colbert
 */
@Document(collection = "indicador_sensores_barragem")
public class IndicadorSensoresBarragem {

    @Id
    private String id;
    private BarragemSimpleDto barragem;
    private Map<TipoSensor, Grau> grauAtencaoSensores;

    public IndicadorSensoresBarragem(BarragemSimpleDto barragem, Map<TipoSensor, Grau> grauAtencaoSensores) {
        this.barragem = barragem;
        this.grauAtencaoSensores = grauAtencaoSensores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BarragemSimpleDto getBarragem() {
        return barragem;
    }

    public void setBarragem(BarragemSimpleDto barragem) {
        this.barragem = barragem;
    }

    public Map<TipoSensor, Grau> getGrauAtencaoSensores() {
        return grauAtencaoSensores;
    }

    public void setGrauAtencaoSensores(Map<TipoSensor, Grau> grauAtencaoSensores) {
        this.grauAtencaoSensores = grauAtencaoSensores;
    }

    @Transient
    public Grau setGrauAtencaoSensor(TipoSensor sensor, Grau grau) {
        return grauAtencaoSensores.put(sensor, grau);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("barragem", barragem)
                .append("grauAtencaoSensores", grauAtencaoSensores)
                .toString();
    }
}
