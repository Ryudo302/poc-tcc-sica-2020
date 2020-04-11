package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "CLASSIFICACAO_BARRAGEM")
public class ClassificacaoBarragem extends AbstractEntidade<Character> {

    @Id
    @Column(name = "COD_CLASSIFICACAO", length = 1)
    private Character codigo;

    @Column(name = "TXT_DESCRICAO", length = 256, nullable = false)
    private String descricao;

    @Override
    public Character getId() {
        return getCodigo();
    }

    public Character getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
