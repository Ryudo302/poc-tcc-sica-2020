package br.pucminas.tcc.sica.portal.aplicacao.api;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.portal.dominio.dto.Modulo;

@RestController
public class ModulosApi {

    private List<Modulo> modulos;

    @PostConstruct
    protected void init() {
        modulos = List.of(
                new Modulo("ativos", "Ativos", System.getenv("MODULO_URL_ATIVOS")),
                new Modulo("monitoramento", "Monitoramento", System.getenv("MODULO_URL_MONITORAMENTO")),
                new Modulo("seguranca", "Segurança", System.getenv("MODULO_URL_SEGURANCA")));
    }

    @GetMapping(value = "/api/modulos", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Modulo> getModulos() {
        return modulos;
    }
}
