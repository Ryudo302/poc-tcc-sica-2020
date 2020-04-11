package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.BarragemService;

@RestController
public class BarragemApi {

    @Autowired
    private BarragemService barragemService;

    @GetMapping(value = "/api/barragens", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Barragem> getTodasBarragens() {
        return barragemService.buscarTodas();
    }
}
