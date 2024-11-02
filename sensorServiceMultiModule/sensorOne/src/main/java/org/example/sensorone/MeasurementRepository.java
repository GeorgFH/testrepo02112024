package org.example.sensorone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for the efficient administration of measurements
 */
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    /**
     * Searches for all measurments of a specific sensor
     * @param sensorId
     * @return list of measurements of a specific sensor
     */
    List<Measurement> findBySensorId(Long sensorId);
}
