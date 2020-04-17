package br.pucminas.tcc.sica.seguranca.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.seguranca.infra.persistencia.AbstractEntidade;

@Entity
@Table(name = "PROCEDIMENTO_SEGURANCA")
public class Procedimento extends AbstractEntidade<Integer> {

    @Id
    @Column(name = "ID_PROCEDIMENTO")
    private Integer id;

    @Column(name = "TXT_NOME_PROCEDIMENTO", length = 50, nullable = false)
    private String nome;

    @Column(name = "TXT_DESCRICAO", length = 256)
    private String descricao;

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
