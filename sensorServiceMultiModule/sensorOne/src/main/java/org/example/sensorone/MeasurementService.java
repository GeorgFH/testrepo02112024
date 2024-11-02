package org.example.sensorone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service class for the administration of measurements
 */
@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    /**
     * Saves a new measurement in the database
     * @param measurement
     * @return
     */
    public Measurement addMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    /**
     * Returns all saved measurements of a specific sensor (in our case sensor one)
     * @param sensorId
     * @return
     */
    public List<Measurement> getMeasurementsBySensorId(Long sensorId) {
        return measurementRepository.findBySensorId(sensorId);
    }

    /**
     * Updates a specific measurement in the database
     * @param id
     * @param newMeasurement
     * @return
     */
    public Measurement updateMeasurement(Long id, Measurement newMeasurement) {
        Measurement measurement = measurementRepository.findById(id).orElse(null);

        if (measurement != null) {
            measurement.setTimestamp(newMeasurement.getTimestamp());
            measurement.setTemperature(newMeasurement.getTemperature());
            measurement.setHumidity(newMeasurement.getHumidity());
            return measurementRepository.save(measurement);
        } else {
            return null;
        }
    }

    /**
     * Deletes a specific measurement in the database
     * @param id
     */
    public void deleteMeasurement(Long id) {
        measurementRepository.deleteById(id);
    }

    /**
     * Deletes all measurements of one specific sensor
     */
    public void deleteMeasurementsBySensorId(Long sensorId) {
        List<Measurement> measurements = measurementRepository.findBySensorId(sensorId);
        measurementRepository.deleteAll(measurements);
    }

}


