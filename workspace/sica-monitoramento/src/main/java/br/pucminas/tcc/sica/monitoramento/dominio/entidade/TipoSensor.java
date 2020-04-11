package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "TIPO_SENSOR")
public class TipoSensor extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "ID_TIPO_SENSOR")
    private Integer id;

    @Column(name = "TXT_DESCRICAO", length = 50, nullable = false)
    private String descricao;
    
    @Override
    public Integer getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
