package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.*;

@Repository
public interface RelatorioEstabilidadeRepository extends JpaRepository<RelatorioEstabilidade, Integer> {

    Optional<RelatorioEstabilidade> findUltimoByBarragem(Barragem barragem);
}
