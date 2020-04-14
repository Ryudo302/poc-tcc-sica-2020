package br.pucminas.tcc.sica.monitoramento.dominio.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.*;

public class RelatorioEstabilidadeDto {

    @JsonProperty(access = Access.READ_ONLY)
    private Integer id;
    @JsonProperty(access = Access.READ_ONLY)
    private NivelClassificacao danoPotencialAssociado;
    @JsonProperty(access = Access.READ_ONLY)
    private NivelClassificacao categoriaRisco;
    @JsonProperty(access = Access.READ_ONLY)
    private ClassificacaoBarragem classificacao;
    @JsonProperty(access = Access.READ_ONLY)
    private LocalDate dataUltimaInspecao;
    @JsonProperty(access = Access.READ_ONLY)
    private boolean ultimoRelatorio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NivelClassificacao getDanoPotencialAssociado() {
        return danoPotencialAssociado;
    }

    public void setDanoPotencialAssociado(NivelClassificacao danoPotencialAssociado) {
        this.danoPotencialAssociado = danoPotencialAssociado;
    }

    public NivelClassificacao getCategoriaRisco() {
        return categoriaRisco;
    }

    public void setCategoriaRisco(NivelClassificacao categoriaRisco) {
        this.categoriaRisco = categoriaRisco;
    }

    public ClassificacaoBarragem getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoBarragem classificacao) {
        this.classificacao = classificacao;
    }

    public LocalDate getDataUltimaInspecao() {
        return dataUltimaInspecao;
    }

    public void setDataUltimaInspecao(LocalDate dataUltimaInspecao) {
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public boolean isUltimoRelatorio() {
        return ultimoRelatorio;
    }

    public void setUltimoRelatorio(boolean ultimoRelatorio) {
        this.ultimoRelatorio = ultimoRelatorio;
    }
}