package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.TipoAtivo;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.TipoAtivoRepository;

@Service
public class TipoAtivoService {

    @Autowired
    private TipoAtivoRepository repository;

    public List<TipoAtivo> buscarTodos() {
        return repository.findAll();
    }
}
