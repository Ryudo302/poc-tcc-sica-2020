package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "BARRAGEM")
public class Barragem extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "ID_BARRAGEM")
    private Integer id;

    @Column(name = "TXT_NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "NUM_CAPACIDADE_TOTAL", precision = 9, nullable = false)
    private Integer capacidadeTotal;

    @Column(name = "NUM_ALTURA_MACICO", precision = 3, nullable = false)
    private Integer alturaMacico;

    @Column(name = "NUM_VOLUME", precision = 9, scale = 2, nullable = false)
    private Double volume;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NUM_NIVEL_EMERGENCIA", referencedColumnName = "NUM_NIVEL")
    private NivelEmergencia nivelEmergencia;

    @Column(name = "ID_ATIVO", precision = 6)
    private Long idAtivo;

    @OneToMany(mappedBy = "barragem", fetch = FetchType.EAGER)
    private Set<Sensor> sensores;

    @OneToMany(mappedBy = "barragem")
    @JsonIgnore
    private Set<RelatorioEstabilidade> relatoriosEstabilidade;

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public Integer getAlturaMacico() {
        return alturaMacico;
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

    public Long getIdAtivo() {
        return idAtivo;
    }

    public Set<Sensor> getSensores() {
        return sensores;
    }

    public Set<RelatorioEstabilidade> getRelatoriosEstabilidade() {
        return relatoriosEstabilidade;
    }
}