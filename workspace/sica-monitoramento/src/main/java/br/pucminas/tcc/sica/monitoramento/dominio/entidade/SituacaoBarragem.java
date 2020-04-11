package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "SITUACAO_BARRAGEM")
public class SituacaoBarragem extends AbstractEntidade<Integer> {

    @Id
    @JoinColumn(name = "ID_BARRAGEM", nullable = false)
    private Integer idBarragem;

    @JoinColumn(name = "ID_BARRAGEM", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Barragem barragem;

    @Column(name = "NUM_VOLUME", precision = 9, scale = 2, nullable = false)
    private Double volume;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NUM_NIVEL")
    private NivelEmergencia nivelEmergencia;

    @Override
    public Integer getId() {
        return getIdBarragem();
    }

    public Integer getIdBarragem() {
        return idBarragem;
    }

    public Barragem getBarragem() {
        return barragem;
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
}
