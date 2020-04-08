package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import org.apache.commons.lang3.builder.*;

import br.pucminas.tcc.sica.monitoramento.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "TIPO_ATIVO")
@SequenceGenerator(allocationSize = 1, name = "IdTipoAtivoSequence", sequenceName = "SQ_ID_TIPO_ATIVO")
public class TipoAtivo extends AbstractEntidade<Integer> {

    @Id
    @GeneratedValue(generator = "IdTipoAtivoSequence")
    @Column(name = "ID_TIPO_ATIVO", precision = 3)
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("descricao", descricao)
                .toString();
    }
}
