package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.repo.SensorRepository;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

}
