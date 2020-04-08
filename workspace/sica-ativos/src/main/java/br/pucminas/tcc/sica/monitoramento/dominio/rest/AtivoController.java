package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Ativo;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.AtivoService;

@RestController
public class AtivoController {

    @Autowired
    private AtivoService service;

    @GetMapping(value = "/ativos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ativo> getTodosAtivo() {
        return service.buscarTodos();
    }
}
