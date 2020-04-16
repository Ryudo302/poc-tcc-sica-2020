package br.pucminas.tcc.sica.monitoramento.dominio.servico;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.sica.monitoramento.dominio.dto.*;
import br.pucminas.tcc.sica.monitoramento.dominio.dto.mapper.BarragemMapper;
import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Barragem;
import br.pucminas.tcc.sica.monitoramento.dominio.repo.BarragemRepository;

@Service
public class BarragemService {

    @Autowired
    private BarragemRepository barragemRepository;
    @Autowired
    private BarragemMapper barragemMapper;

    public List<BarragemSimpleDto> buscarTodas() {
        return barragemRepository.findAll(Sort.by(Direction.DESC, "nivelEmergencia.nivel"))
                .stream()
                .map(barragemMapper::converterParaBarragemSimpleDto)
                .collect(Collectors.toList());
    }

    public Optional<BarragemDto> buscarComSensoresPorId(Integer id) {
        Objects.requireNonNull(id, "id");
        return barragemRepository.findByIdWithSensores(id)
                .map(barragemMapper::converterParaBarragemDto);
    }

    public Optional<Barragem> buscarPorId(Integer id) {
        Objects.requireNonNull(id, "id");
        return barragemRepository.findById(id);
    }

    public Barragem salvar(Barragem barragem) {
        Objects.requireNonNull(barragem, "barragem");
        return barragemRepository.save(barragem);
    }
}
