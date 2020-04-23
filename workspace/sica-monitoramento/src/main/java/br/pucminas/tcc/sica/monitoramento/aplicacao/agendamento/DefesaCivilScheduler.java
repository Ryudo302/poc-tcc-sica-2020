package br.pucminas.tcc.sica.monitoramento.aplicacao.agendamento;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.monitoramento.dominio.servico.*;

@Component
public class DefesaCivilScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefesaCivilScheduler.class);

    @Autowired
    private DefesaCivilService defesaCivilService;
    @Autowired
    private BarragemService barragemService;

    @Scheduled(fixedDelay = 10000)
    public void enviarDadosBarragens() {
        LOGGER.info("Enviando dados das barragen para a Defesa Civil");
        barragemService.buscarTodas().forEach(defesaCivilService::enviar);
    }
}
