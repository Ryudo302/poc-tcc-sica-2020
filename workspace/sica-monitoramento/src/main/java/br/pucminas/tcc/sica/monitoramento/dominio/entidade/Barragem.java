package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

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

    @Column(name = "ID_ATIVO", precision = 6)
    private Long idAtivo;

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

    public Long getIdAtivo() {
        return idAtivo;
    }
}
