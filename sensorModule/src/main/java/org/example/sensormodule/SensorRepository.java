package org.example.sensormodule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for the efficient administration of sensors (in our case of the sensor)
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByType(String type);
    // Zusätzliche benutzerdefinierte Methoden können hier hinzugefügt werden, falls nötig
}
