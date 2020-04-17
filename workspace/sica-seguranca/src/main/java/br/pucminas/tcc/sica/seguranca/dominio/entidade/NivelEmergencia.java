package br.pucminas.tcc.sica.seguranca.dominio.entidade;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.pucminas.tcc.sica.seguranca.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "NIVEL_EMERGENCIA")
public class NivelEmergencia extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "NUM_NIVEL", precision = 1)
    private Integer nivel;

    @Column(name = "TXT_DESCRICAO", length = 256, nullable = false)
    private String descricao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PROCEDIMENTO_NIVEL_EMERGENCIA", joinColumns = {
            @JoinColumn(name = "NUM_NIVEL_EMERGENCIA", referencedColumnName = "NUM_NIVEL")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ID_PROCEDIMENTO")
    })
    private Set<Procedimento> procedimentos;

    public NivelEmergencia(Integer nivel) {
        this.nivel = nivel;
    }

    public NivelEmergencia() {
        this(null);
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return getNivel();
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(Set<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
