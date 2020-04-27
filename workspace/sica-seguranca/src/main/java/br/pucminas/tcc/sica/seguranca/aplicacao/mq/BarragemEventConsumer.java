package br.pucminas.tcc.sica.seguranca.aplicacao.mq;

import java.time.LocalDateTime;

import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import br.pucminas.tcc.sica.seguranca.dominio.dto.BarragemSimpleDto;
import br.pucminas.tcc.sica.seguranca.dominio.entidade.*;
import br.pucminas.tcc.sica.seguranca.dominio.servico.BarragemService;
import br.pucminas.tcc.sica.seguranca.infra.WebSocketConfiguration;

@Component
public class BarragemEventConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BarragemEventConsumer.class);

    @Autowired
    private SimpMessagingTemplate websocket;

    @Autowired
    private BarragemService barragemService;

    @RabbitListener(autoStartup = "false", queues = { "${sica.mq.queue.barragem}" })
    public void receberEvento(BarragemSimpleDto barragemDto) {
        Barragem barragem = barragemService.buscarPorId(barragemDto.getId())
                .orElseGet(() -> criarNovaBarragem(barragemDto));

        LOGGER.info("Barragem {} mudou nível de segurança para {}", barragem.getNome(), barragemDto.getNivelEmergencia());

        barragem.setNivelEmergencia(new NivelEmergencia(barragemDto.getNivelEmergencia()));
        barragem.setDataUltimaAtualizacao(LocalDateTime.now());

        barragemService.salvar(barragem);

        LOGGER.debug("Enviando via WebSockets informações da barragem: {}", barragemDto);
        websocket.convertAndSend(WebSocketConfiguration.MESSAGE_PREFIX + "/barragem", barragemDto);
    }

    private Barragem criarNovaBarragem(BarragemSimpleDto barragemDto) {
        Barragem barragem = new Barragem();
        barragem.setId(barragemDto.getId());
        barragem.setNome(barragemDto.getNome());
        return barragem;
    }
}
