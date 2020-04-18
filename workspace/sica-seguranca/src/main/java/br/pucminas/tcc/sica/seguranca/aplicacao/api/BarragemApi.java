package br.pucminas.tcc.sica.seguranca.aplicacao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.seguranca.dominio.servico.BarragemService;

@RestController
public class BarragemApi {

    @Autowired
    private BarragemService barragemService;

    @GetMapping(value = "/api/barragens", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Barragem> getTodasBarragens() {
        return barragemService.buscarTodas();
    }

    @GetMapping(value = "/api/barragens/{idBarragem}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Barragem getBarragem(@PathVariable("idBarragem") int idBarragem) {
        return barragemService.buscarPorId(idBarragem)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barragem não encontrada: " + idBarragem));
    }
}
