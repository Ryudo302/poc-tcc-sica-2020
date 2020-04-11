package br.pucminas.tcc.sica.ativos.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.ativos.dominio.entidade.TipoAtivo;

@Repository
public interface TipoAtivoRepository extends JpaRepository<TipoAtivo, Integer> {

}
