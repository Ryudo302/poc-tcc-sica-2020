package br.pucminas.tcc.sica.monitoramento.dominio.entidade;

import javax.persistence.*;

import br.pucminas.tcc.sica.commons.persistencia.AbstractEntidade;

@Entity
@Table(name = "SENSOR")
public class Sensor extends AbstractEntidade<Long> {

    @Id
    @Column(name = "ID_SENSOR")
    private Long id;

    @Column(name = "TXT_ID_HARDWARE", length = 10, nullable = false)
    private String idHardware;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TIPO_SENSOR")
    private TipoSensor tipo;

    @Column(name = "ID_ATIVO", precision = 6)
    private Long idAtivo;

    @Override
    public Long getId() {
        return id;
    }

    public String getIdHardware() {
        return idHardware;
    }

    public TipoSensor getTipo() {
        return tipo;
    }

    public Long getIdAtivo() {
        return idAtivo;
    }
}
