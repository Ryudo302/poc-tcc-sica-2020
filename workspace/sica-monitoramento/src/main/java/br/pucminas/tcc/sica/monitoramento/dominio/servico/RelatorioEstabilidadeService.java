package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.*;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.RelatorioEstabilidadeRepository;

@Service
public class RelatorioEstabilidadeService {

    @Autowired
    private RelatorioEstabilidadeRepository relatorioEstabilidadeRepository;

    public List<RelatorioEstabilidade> buscarRelatorios(Barragem barragem, boolean ultimo) {
        Objects.requireNonNull(barragem, "barragem");
        return ultimo
                ? relatorioEstabilidadeRepository.findUltimoByBarragem(barragem)
                        .map(Arrays::asList)
                        .orElse(Collections.emptyList())
                : buscarTodosPorBarragem(barragem);
    }

    private List<RelatorioEstabilidade> buscarTodosPorBarragem(Barragem barragem) {
        RelatorioEstabilidade example = new RelatorioEstabilidade();
        example.setBarragem(barragem);
        return relatorioEstabilidadeRepository.findAll(Example.of(example));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void salvarRelatorio(RelatorioEstabilidade relatorio) {
        Objects.requireNonNull(relatorio, "relatorio");

        buscarRelatorios(relatorio.getBarragem(), true).stream().forEach(ultimoRelatorioAnterior -> {
            ultimoRelatorioAnterior.setUltimoRelatorio(false);
            relatorioEstabilidadeRepository.save(ultimoRelatorioAnterior);
        });

        relatorio.setUltimoRelatorio(true);
        relatorioEstabilidadeRepository.save(relatorio);
    }
}
