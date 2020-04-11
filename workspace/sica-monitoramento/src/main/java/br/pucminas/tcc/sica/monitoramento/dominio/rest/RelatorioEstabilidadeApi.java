package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.RelatorioEstabilidade;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.*;

@RestController
public class RelatorioEstabilidadeApi {

    @Autowired
    private BarragemService barragemService;
    @Autowired
    private RelatorioEstabilidadeService relatorioEstabilidadeService;

    @GetMapping(value = "/api/relatorios-estabilidade")
    public List<RelatorioEstabilidade> buscarRelatorios(@RequestParam("idBarragem") Integer idBarragem,
            @RequestParam(name = "ultimo", defaultValue = "false") Boolean ultimo) {
        return barragemService.buscarPorId(idBarragem)
                .map(barragem -> relatorioEstabilidadeService.buscarRelatorios(barragem, ultimo))
                .orElse(Collections.emptyList());
    }
}
