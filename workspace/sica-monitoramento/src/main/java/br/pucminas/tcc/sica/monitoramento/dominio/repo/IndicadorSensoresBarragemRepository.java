package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.IndicadorSensoresBarragem;

@Repository
public interface IndicadorSensoresBarragemRepository extends MongoRepository<IndicadorSensoresBarragem, String> {

    Optional<IndicadorSensoresBarragem> findByBarragemId(int id);
}
