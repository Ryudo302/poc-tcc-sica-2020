package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.BarragemRepository;

@Service
public class BarragemService {

    @Autowired
    private BarragemRepository barragemRepository;

    public List<Barragem> buscarTodas() {
        return barragemRepository.findAll();
    }
}
