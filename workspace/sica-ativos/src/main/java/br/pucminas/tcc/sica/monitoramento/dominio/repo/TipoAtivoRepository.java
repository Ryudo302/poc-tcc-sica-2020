package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.TipoAtivo;

@Repository
public interface TipoAtivoRepository extends JpaRepository<TipoAtivo, Integer> {

}
