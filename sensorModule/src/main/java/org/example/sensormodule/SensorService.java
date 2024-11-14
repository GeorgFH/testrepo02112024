package org.example.sensormodule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for the administration of sensors (in our case one sensor)
 */
@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;


    /**
     * Creates a new sensor object
     * @param sensor
     * @return
     */
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }


    /**
     * Returns the specific information of the generated sensor
     * @return
     */
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));
    }

    /**
     * Returns the specific information of all generated sensors
     * @return
     */
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    /**
     * Updates the information of a specific sensor by id
     * @param id
     * @param updatedSensor
     * @return
     */
    public Sensor updateSensor(Long id, Sensor updatedSensor) {
        Sensor sensor = sensorRepository.findById(id).orElse(null);

        if (sensor != null) {
            sensor.setName(updatedSensor.getName());
            sensor.setLocation(updatedSensor.getLocation());
            sensor.setType(updatedSensor.getType());
            sensor.setActive(updatedSensor.isActive());
            return sensorRepository.save(sensor);
        } else {
            return null;
        }
    }

    /**
     * Deletes a specific sensor by id
     */
    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
}
