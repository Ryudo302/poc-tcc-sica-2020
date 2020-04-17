package br.pucminas.tcc.sica.monitoramento.infra.rest;

import java.util.Objects;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.BarragemSimpleDto;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.DefesaCivilService;

/**
 * Serviço responsável por enviar informações à Defesa Civil Estadual e à Municipal.
 * 
 * @author Thiago Colbert
 */
@Service
public class DefesaCivilRestService implements DefesaCivilService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefesaCivilRestService.class);

    @Autowired
    private RestTemplate defesaCivilEstadual;
    @Autowired
    private RestTemplate defesaCivilMunicipal;

    @Override
    public void enviar(BarragemSimpleDto barragemDto) {
        Objects.requireNonNull(barragemDto, "barragemDto");

        LOGGER.debug("Enviando para a Defesa Civil Estadual: {}", barragemDto);
        ResponseEntity<Object> resposta = defesaCivilEstadual.postForEntity("/informacoes-barragem", barragemDto, null);
        LOGGER.debug("Resposta da Defesa Civil Estadual: {} {}", resposta.getStatusCodeValue(), resposta.getStatusCode().getReasonPhrase());

        LOGGER.debug("Enviando para a Defesa Civil Municipal: {}", barragemDto);
        defesaCivilMunicipal.postForEntity("/informacoes-barragem", barragemDto, null);
        LOGGER.debug("Resposta da Defesa Civil Municipal: {} {}", resposta.getStatusCodeValue(), resposta.getStatusCode().getReasonPhrase());
    }
}
