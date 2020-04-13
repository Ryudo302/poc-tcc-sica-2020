package br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper;

import org.mapstruct.*;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.*;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Barragem;

@Mapper(componentModel = "spring", uses = { SensorMapper.class })
public interface BarragemMapper {

    @Mappings({
        @Mapping(target = "nivelEmergencia", source = "nivelEmergencia.nivel")
    })
    BarragemSimpleDto converterParaBarragemSimpleDto(Barragem barragem);

    BarragemDto converterParaBarragemDto(Barragem barragem);
}
