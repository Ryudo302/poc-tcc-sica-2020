package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Ativo;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.AtivoRepository;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository repository;

    public List<Ativo> buscarTodos() {
        return repository.findAll(Sort.by(Direction.ASC, "dataAquisicao"));
    }

    public Optional<Ativo> buscarPeloId(long idAtivo) {
        return repository.findById(idAtivo);
    }
}
