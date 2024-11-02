package org.example.sensorone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the efficient administration of sensors (in our case of the sensor)
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    // Zusätzliche benutzerdefinierte Methoden können hier hinzugefügt werden, falls nötig
}
