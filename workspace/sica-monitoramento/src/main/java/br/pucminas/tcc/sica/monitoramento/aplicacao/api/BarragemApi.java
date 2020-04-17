package br.pucminas.tcc.sica.monitoramento.aplicacao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.*;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.BarragemService;

@RestController
public class BarragemApi {

    @Autowired
    private BarragemService barragemService;

    @GetMapping(value = "/api/barragens", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BarragemSimpleDto> getTodasBarragens() {
        return barragemService.buscarTodas();
    }

    @GetMapping(value = "/api/barragens/{idBarragem}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BarragemDto getBarragem(@PathVariable("idBarragem") int idBarragem) {
        return barragemService.buscarComSensoresPorId(idBarragem)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barragem não encontrada: " + idBarragem));
    }
}
