package br.pucminas.tcc.sica.seguranca.dominio.servico;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.seguranca.dominio.repo.BarragemRepository;

@Service
public class BarragemService {

    @Autowired
    private BarragemRepository barragemRepository;

    public List<Barragem> buscarTodas() {
        return barragemRepository.findAll(Sort.by(Direction.DESC, "nivelEmergencia.nivel"));
    }

    public Optional<Barragem> buscarPorId(Integer id) {
        Objects.requireNonNull(id, "id");
        return barragemRepository.findById(id);
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRED)
    public Barragem salvar(Barragem barragem) {
        Objects.requireNonNull(barragem, "barragem");
        return barragemRepository.save(barragem);
    }
}
