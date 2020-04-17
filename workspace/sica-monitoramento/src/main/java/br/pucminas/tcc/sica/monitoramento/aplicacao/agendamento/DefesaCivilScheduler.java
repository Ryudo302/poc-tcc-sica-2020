package br.pucminas.tcc.sica.monitoramento.aplicacao.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.monitoramento.dominio.servico.*;

@Component
public class DefesaCivilScheduler {

    @Autowired
    private DefesaCivilService defesaCivilService;
    @Autowired
    private BarragemService barragemService;

    @Scheduled(fixedDelay = 10000)
    public void enviarDadosBarragens() {
        barragemService.buscarTodas().forEach(defesaCivilService::enviar);
    }
}
