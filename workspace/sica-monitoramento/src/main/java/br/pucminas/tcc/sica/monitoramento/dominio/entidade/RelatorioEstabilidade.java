package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import java.time.LocalDate;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "RELATORIO_ESTABILIDADE")
public class RelatorioEstabilidade extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "ID_RELATORIO")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_BARRAGEM", nullable = false)
    private Barragem barragem;

    @Column(name = "NUM_DANO_POTENCIAL_ASSOCIADO", precision = 1, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private NivelClassificacao danoPotencialAssociado;

    @Column(name = "NUM_CATEGORIA_RISCO", precision = 1, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private NivelClassificacao categoriaRisco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COD_CLASSIFICACAO", nullable = false)
    private ClassificacaoBarragem classificacao;

    @Column(name = "DTA_ULTIMA_INSPECAO", nullable = false)
    private LocalDate dataUltimaInspecao;

    @Override
    public Integer getId() {
        return id;
    }

    public Barragem getBarragem() {
        return barragem;
    }

    public NivelClassificacao getDanoPotencialAssociado() {
        return danoPotencialAssociado;
    }

    public NivelClassificacao getCategoriaRisco() {
        return categoriaRisco;
    }

    public ClassificacaoBarragem getClassificacao() {
        return classificacao;
    }

    public LocalDate getDataUltimaInspecao() {
        return dataUltimaInspecao;
    }
}
