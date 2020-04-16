package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.LeituraSensor;

@Repository
public interface LeituraSensorRepository extends MongoRepository<LeituraSensor, String> {

}
