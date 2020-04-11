package br.pucminas.tcc.sica.ativos.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.ativos.dominio.entidade.Ativo;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

}
