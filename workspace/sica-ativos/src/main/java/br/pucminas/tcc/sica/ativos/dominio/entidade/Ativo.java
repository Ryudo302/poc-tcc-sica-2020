package br.pucminas.tcc.sica.ativos.dominio.entidade;

import java.time.*;

import javax.persistence.*;

import org.apache.commons.lang3.builder.*;

import br.pucminas.tcc.sica.ativos.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "ATIVO")
@SequenceGenerator(allocationSize = 1, name = "IdAtivoSequence", sequenceName = "SQ_ID_ATIVO")
public class Ativo extends AbstractEntidade<Long> {

    @Id
    @GeneratedValue(generator = "IdAtivoSequence")
    @Column(name = "ID_ATIVO", precision = 6)
    private Long id;

    @Column(name = "TXT_DESCRICAO", length = 100, nullable = false)
    private String descricao;

    @Column(name = "TXT_NOME_IMAGEM", length = 50, nullable = false)
    private String nomeImagem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TIPO_ATIVO", nullable = false)
    private TipoAtivo tipo;

    @Column(name = "DTA_AQUISICAO", nullable = false)
    private LocalDate dataAquisicao;

    @Column(name = "DTA_ULTIMA_MANUTENCAO")
    private LocalDateTime dataUltimaManutencao;

    @Column(name = "DTA_PROXIMA_MANUTENCAO")
    private LocalDateTime dataProximaManutencao;
    
    @Column(name = "IND_EM_FUNCIONAMENTO", nullable = false)
    private boolean emFuncionamento;

    @Override
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public TipoAtivo getTipo() {
        return tipo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public LocalDateTime getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }

    public LocalDateTime getDataProximaManutencao() {
        return dataProximaManutencao;
    }
    
    public boolean isEmFuncionamento() {
        return emFuncionamento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("descricao", descricao)
                .append("tipo", tipo)
                .toString();
    }
}
