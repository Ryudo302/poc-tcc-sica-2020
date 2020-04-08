package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Ativo;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

}
