package br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper;

import org.mapstruct.Mapper;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.LeituraSensorDto;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.LeituraSensor;

@Mapper(componentModel = "spring")
public interface LeituraSensorMapper {

    LeituraSensorDto converterLeituraSensorParaDto(LeituraSensor leituraSensor);
}
