package org.example.sensortwo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    // Zusätzliche benutzerdefinierte Methoden können hier hinzugefügt werden, falls nötig
}
