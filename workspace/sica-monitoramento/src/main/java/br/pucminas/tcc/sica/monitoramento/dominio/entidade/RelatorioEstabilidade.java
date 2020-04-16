package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import java.time.LocalDate;

import javax.persistence.*;

import br.pucminas.tcc.sica.monitoramento.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "RELATORIO_ESTABILIDADE")
@SequenceGenerator(allocationSize = 1, name = "IdRelatorioEstabilidadeGenerator")
@NamedQueries({
        @NamedQuery(name = RelatorioEstabilidade.QUERY_FIND_ULTIMO_BY_BARRAGEM, query = "SELECT re FROM RelatorioEstabilidade re WHERE re.barragem = ?1 AND re.ultimoRelatorio = TRUE")
})
public class RelatorioEstabilidade extends AbstractEntidade<Integer> {

    public static final String QUERY_FIND_ULTIMO_BY_BARRAGEM = "RelatorioEstabilidade.findUltimoByBarragem";

    @Id
    @Column(name = "ID_RELATORIO")
    @GeneratedValue(generator = "IdRelatorioEstabilidadeGenerator")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_BARRAGEM", nullable = false)
    private Barragem barragem;

    @Column(name = "NUM_DANO_POTENCIAL_ASSOCIADO", precision = 1, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Grau danoPotencialAssociado;

    @Column(name = "NUM_CATEGORIA_RISCO", precision = 1, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Grau categoriaRisco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COD_CLASSIFICACAO", nullable = false)
    private ClassificacaoBarragem classificacao;

    @Column(name = "DTA_ULTIMA_INSPECAO", nullable = false)
    private LocalDate dataUltimaInspecao;

    @Column(name = "IND_ULTIMO_RELATORIO", nullable = false)
    private boolean ultimoRelatorio;

    @Override
    public Integer getId() {
        return id;
    }

    public Barragem getBarragem() {
        return barragem;
    }

    public void setBarragem(Barragem barragem) {
        this.barragem = barragem;
    }

    public Grau getDanoPotencialAssociado() {
        return danoPotencialAssociado;
    }

    public void setDanoPotencialAssociado(Grau danoPotencialAssociado) {
        this.danoPotencialAssociado = danoPotencialAssociado;
    }

    public Grau getCategoriaRisco() {
        return categoriaRisco;
    }

    public void setCategoriaRisco(Grau categoriaRisco) {
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
