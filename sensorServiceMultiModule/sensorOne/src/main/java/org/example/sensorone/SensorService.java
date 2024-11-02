package org.example.sensorone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for the administration of sensors (in our case one sensor)
 */
@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    /**
     * Returns the specific information of the generated sensor
     * @return
     */
    public Sensor getSingleSensor() {
        if (sensorRepository.existsById(1L)) {
            return sensorRepository.findById(1L).get();
        } else {
            return null;
        }
    }

    /**
     * Creates/Updates our sensor with the ID 1
     * @param sensor
     * @return
     */
    public Sensor createOrUpdateSensor(Sensor sensor) {
        sensor.setId(1L);
        return sensorRepository.save(sensor);
    }

    /**
     * Deletes our sensor with the ID 1
     */
    public void deleteSensor() {
        sensorRepository.deleteAll();
    }
}
