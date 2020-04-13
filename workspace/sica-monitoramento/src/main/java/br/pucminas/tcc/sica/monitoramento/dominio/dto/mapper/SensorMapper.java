package br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper;

import org.mapstruct.Mapper;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.SensorDto;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Sensor;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    SensorDto converterSensorParaDto(Sensor sensor);
}
