package br.pucminas.tcc.sica.seguranca.dominio.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.seguranca.dominio.repo.BarragemRepository;

@Service
public class BarragemService {

    @Autowired
    private BarragemRepository barragemRepository;

    public List<Barragem> buscarTodas() {
        return barragemRepository.findAll(Sort.by(Direction.DESC, "nivelEmergencia.nivel"));
    }
}
