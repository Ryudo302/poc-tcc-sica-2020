package br.pucminas.tcc.sica.ativos.dominio.servico;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.ativos.dominio.entidade.*;
import br.pucminas.tcc.sica.ativos.dominio.repo.AtivoRepository;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository repository;

    public List<Ativo> buscar(Integer idTipoAtivo) {
        return idTipoAtivo != null
                ? repository.findByTipo(new TipoAtivo(idTipoAtivo), Sort.by(Direction.ASC, "dataAquisicao"))
                : repository.findAll(Sort.by(Direction.ASC, "dataAquisicao"));
    }

    public Optional<Ativo> buscarPeloId(long idAtivo) {
        return repository.findById(idAtivo);
    }
}
