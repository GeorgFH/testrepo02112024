package org.example.sensortwo;
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
     * Returns the specific information of the generated sensor 2
     * @return
     */
    public Sensor getSingleSensor() {
        if (sensorRepository.existsById(2L)) {
            return sensorRepository.findById(2L).get();
        } else {
            return null;
        }
    }

    /**
     * Creates/Updates our sensor with the ID 2
     * @param sensor
     * @return
     */
    public Sensor createOrUpdateSensor(Sensor sensor) {
        sensor.setId(2L);
        return sensorRepository.save(sensor);
    }

    /**
     * Deletes our sensor with the ID 2
     */
    public void deleteSensor() {
        sensorRepository.deleteAll();
    }
}
