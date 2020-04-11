package br.pucminas.tcc.sica.ativos.dominio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.ativos.dominio.entidade.TipoAtivo;
import br.pucminas.tcc.sica.ativos.dominio.servico.TipoAtivoService;

@RestController
public class TipoAtivoApi {

    @Autowired
    private TipoAtivoService service;

    @GetMapping(value = "/api/tipos-ativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoAtivo> getTodosTiposAtivo() {
        return service.buscarTodos();
    }
}
