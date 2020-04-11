package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "NIVEL_EMERGENCIA")
public class NivelEmergencia extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "NUM_NIVEL")
    private Integer nivel;

    @Column(name = "TXT_DESCRICAO", length = 256, nullable = false)
    private String descricao;

    @Override
    public Integer getId() {
        return getNivel();
    }

    public Integer getNivel() {
        return nivel;
    }
}
