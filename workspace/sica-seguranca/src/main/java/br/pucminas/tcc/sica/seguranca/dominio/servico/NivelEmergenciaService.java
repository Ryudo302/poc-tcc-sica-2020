package br.pucminas.tcc.sica.seguranca.dominio.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.NivelEmergencia;
import br.pucminas.tcc.sica.seguranca.dominio.repo.NivelEmergenciaRepository;

@Service
public class NivelEmergenciaService {

    @Autowired
    private NivelEmergenciaRepository nivelEmergenciaRepository;

    public List<NivelEmergencia> buscarTodos() {
        return nivelEmergenciaRepository.findAll(Sort.by(Direction.ASC, "nivel"));
    }
}
