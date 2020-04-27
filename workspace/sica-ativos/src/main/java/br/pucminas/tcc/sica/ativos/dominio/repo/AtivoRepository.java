package br.pucminas.tcc.sica.ativos.dominio.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.ativos.dominio.entidade.*;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

    List<Ativo> findByTipo(TipoAtivo tipo, Sort sort);
}
