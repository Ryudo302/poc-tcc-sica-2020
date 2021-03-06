package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.pucminas.tcc.sica.monitoramento.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "NIVEL_EMERGENCIA")
public class NivelEmergencia extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "NUM_NIVEL")
    private Integer nivel;

    @Column(name = "TXT_DESCRICAO", length = 256, nullable = false)
    private String descricao;

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
}
