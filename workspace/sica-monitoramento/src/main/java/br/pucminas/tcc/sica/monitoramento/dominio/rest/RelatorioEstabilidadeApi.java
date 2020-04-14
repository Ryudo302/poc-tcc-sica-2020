package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.RelatorioEstabilidadeDto;
import br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper.RelatorioEstabilidadeMapper;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.RelatorioEstabilidade;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.*;

@RestController
public class RelatorioEstabilidadeApi {

    @Autowired
    private BarragemService barragemService;
    @Autowired
    private RelatorioEstabilidadeService relatorioEstabilidadeService;
    @Autowired
    private RelatorioEstabilidadeMapper relatorioEstabilidadeMapper;

    @GetMapping(value = "/api/relatorios-estabilidade", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<RelatorioEstabilidadeDto> getRelatorios(@RequestParam("idBarragem") Integer idBarragem,
            @RequestParam(name = "ultimo", defaultValue = "false") Boolean ultimo) {
        return barragemService.buscarPorId(idBarragem)
                .map(barragem -> relatorioEstabilidadeService.buscarRelatorios(barragem, ultimo))
                .stream()
                .flatMap(List::stream)
                .map(relatorioEstabilidadeMapper::converterRelatorioEstabilidadeParaDto)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/api/relatorios-estabilidade", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public void postRelatorio(@RequestBody RelatorioEstabilidadeDto dto) {
        RelatorioEstabilidade relatorioEstabilidade = relatorioEstabilidadeMapper.converterDtoParaRelatorioEstabilidade(dto);
        relatorioEstabilidadeService.salvarRelatorio(relatorioEstabilidade);
    }
}
