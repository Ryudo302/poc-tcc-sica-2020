package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.RelatorioEstabilidadeDto;
import br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper.RelatorioEstabilidadeMapper;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.*;

@RestController
public class RelatorioEstabilidadeApi {

    @Autowired
    private BarragemService barragemService;
    @Autowired
    private RelatorioEstabilidadeService relatorioEstabilidadeService;
    @Autowired
    private RelatorioEstabilidadeMapper relatorioEstabilidadeMapper;

    @GetMapping(value = "/api/relatorios-estabilidade")
    public List<RelatorioEstabilidadeDto> buscarRelatorios(@RequestParam("idBarragem") Integer idBarragem,
            @RequestParam(name = "ultimo", defaultValue = "false") Boolean ultimo) {
        return barragemService.buscarPorId(idBarragem)
                .map(barragem -> relatorioEstabilidadeService.buscarRelatorios(barragem, ultimo))
                .stream()
                .flatMap(List::stream)
                .map(relatorioEstabilidadeMapper::converterRelatorioEstabilidadeParaDto)
                .collect(Collectors.toList());
    }
}
