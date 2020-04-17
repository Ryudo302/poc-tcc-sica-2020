package br.pucminas.tcc.sica.seguranca.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.seguranca.dominio.entidade.NivelEmergencia;

@Repository
public interface NivelEmergenciaRepository extends JpaRepository<NivelEmergencia, Integer> {

}
