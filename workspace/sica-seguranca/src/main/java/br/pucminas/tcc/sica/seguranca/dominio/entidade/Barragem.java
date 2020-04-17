package br.pucminas.tcc.sica.seguranca.dominio.entidade;

import java.time.LocalDateTime;

import javax.persistence.*;

import br.pucminas.tcc.sica.seguranca.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "BARRAGEM")
public class Barragem extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "ID_BARRAGEM")
    private Integer id;

    @Column(name = "TXT_NOME", length = 50, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "NUM_NIVEL_EMERGENCIA", referencedColumnName = "NUM_NIVEL")
    private NivelEmergencia nivelEmergencia;

    @Column(name = "ID_ATIVO", precision = 6)
    private Long idAtivo;

    @Column(name = "DTA_ULTIMA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Override
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

    public NivelEmergencia getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(NivelEmergencia nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }

    public Long getIdAtivo() {
        return idAtivo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
