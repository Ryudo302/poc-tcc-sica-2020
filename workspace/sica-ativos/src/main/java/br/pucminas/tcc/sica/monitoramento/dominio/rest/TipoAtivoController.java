package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.TipoAtivo;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.TipoAtivoService;

@RestController
public class TipoAtivoController {

    @Autowired
    private TipoAtivoService service;

    @GetMapping(value = "/tipos-ativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoAtivo> getTodosTiposAtivo() {
        return service.buscarTodos();
    }
}
