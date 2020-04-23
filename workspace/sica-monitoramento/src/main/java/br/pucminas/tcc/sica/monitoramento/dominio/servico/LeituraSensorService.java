package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.Objects;

import org.slf4j.*;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.*;
import br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper.BarragemMapper;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.*;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.LeituraSensorRepository;
import br.pucminas.tcc.sica.monitoramento.infra.WebSocketConfiguration;

@Service
public class LeituraSensorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeituraSensorService.class);

    @Autowired
    private SimpMessagingTemplate websocket;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Exchange exchange;

    @Autowired
    public BarragemService barragemService;
    @Autowired
    private BarragemMapper barragemMapper;

    @Autowired
    private LeituraSensorRepository leituraSensorRepository;

    @Async
    public void atualizarNivelEmergencia(Barragem barragem, Sensor sensor, LeituraSensorDto leituraSensor) {
        Objects.requireNonNull(barragem, "barragem");
        Objects.requireNonNull(sensor, "sensor");

        // regras de negócio para identificação automática do nível de emergência da barragem, que não serão implementadas nesse momento

        // início do código simulador
        Integer nivelEmergenciaAtual = barragem.getNivelEmergencia().getNivel();
        Integer nivelEmergenciaNovo = nivelEmergenciaAtual;

        if (leituraSensor.getVariacao() >= 1.8) {
            if (nivelEmergenciaAtual == 0) {
                nivelEmergenciaNovo++;
            } else if (nivelEmergenciaAtual == 3) {
                nivelEmergenciaNovo--;
            } else {
                nivelEmergenciaNovo += (Math.random() < 0.5 ? 1 : -1);
            }
        }
        // fim do código simulador

        if (!nivelEmergenciaNovo.equals(nivelEmergenciaAtual)) {
            LOGGER.info("Atualizando nível de emergência da barragem {} de {} para {}", barragem.getNome(), nivelEmergenciaAtual, nivelEmergenciaNovo);
            barragem.setNivelEmergencia(new NivelEmergencia(nivelEmergenciaNovo));
            barragemService.salvar(barragem);

            BarragemSimpleDto barragemDto = barragemMapper.converterParaBarragemSimpleDto(barragem);

            LOGGER.debug("Enviando via WebSockets o novo nível de emergência da barragem {}: {}", barragem.getNome(), barragem.getNivelEmergencia());
            websocket.convertAndSend(WebSocketConfiguration.MESSAGE_PREFIX + "/barragem", barragemDto);

            LOGGER.debug("Enviando notificação MQ sobre o novo nível de emergência da barragem {}: {}", barragem.getNome(),
                    barragem.getNivelEmergencia());
            rabbitTemplate.convertAndSend(exchange.getName(), "barragem.nivelSeguranca", barragemDto);
        }
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRED)
    public void salvar(LeituraSensor leituraSensor) {
        leituraSensorRepository.save(Objects.requireNonNull(leituraSensor, "leituraSensor"));
    }
}
