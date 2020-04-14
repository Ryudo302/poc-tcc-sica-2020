package br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper;

import org.mapstruct.Mapper;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.RelatorioEstabilidadeDto;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.RelatorioEstabilidade;

@Mapper(componentModel = "spring")
public interface RelatorioEstabilidadeMapper {

    RelatorioEstabilidadeDto converterRelatorioEstabilidadeParaDto(RelatorioEstabilidade relatorio);
}
