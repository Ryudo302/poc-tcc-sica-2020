package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.*;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.RelatorioEstabilidadeRepository;

@Service
public class RelatorioEstabilidadeService {

    @Autowired
    private RelatorioEstabilidadeRepository relatorioEstabilidadeRepository;

    public Optional<RelatorioEstabilidade> buscarUltimoRelatorio(Barragem barragem) {
        Objects.requireNonNull(barragem, "barragem");
        return relatorioEstabilidadeRepository.findUltimoByBarragem(barragem);
    }
}
