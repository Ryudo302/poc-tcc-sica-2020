package br.pucminas.tcc.sica.seguranca.aplicacao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.NivelEmergencia;
import br.pucminas.tcc.sica.seguranca.dominio.servico.NivelEmergenciaService;

@RestController
public class NivelEmergenciaApi {

    @Autowired
    private NivelEmergenciaService nivelEmergenciaService;

    @GetMapping(value = "/api/niveis-emergencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NivelEmergencia> getTodosNiveisEmergencia() {
        return nivelEmergenciaService.buscarTodos();
    }
}
