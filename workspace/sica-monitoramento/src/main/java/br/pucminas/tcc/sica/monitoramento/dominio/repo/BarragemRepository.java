package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Barragem;

@Repository
public interface BarragemRepository extends JpaRepository<Barragem, Integer> {

    Optional<Barragem> findByIdWithSensores(int id);
}
