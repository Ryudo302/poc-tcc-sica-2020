package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.BarragemSimpleDto;

public interface DefesaCivilService {

    void enviar(BarragemSimpleDto barragemDto);
}
