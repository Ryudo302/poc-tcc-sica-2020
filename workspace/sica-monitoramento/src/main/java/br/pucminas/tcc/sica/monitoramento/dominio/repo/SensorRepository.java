package br.pucminas.tcc.sica.monitoramento.dominio.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query("SELECT s FROM Sensor s JOIN FETCH s.barragem WHERE s.idHardware = (:idHardware)")
    Optional<Sensor> findByIdHardware(@Param("idHardware") String idHardware);
}
