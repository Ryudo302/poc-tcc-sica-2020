package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
