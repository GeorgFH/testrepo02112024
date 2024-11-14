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
     * Creates a sensor
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

    // Alle Sensoren abrufen
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    // Sensor aktualisieren
    public Sensor updateSensor(Long id, Sensor updatedSensor) {
        Sensor sensor = getSensorById(id);
        sensor.setName(updatedSensor.getName());
        sensor.setLocation(updatedSensor.getLocation());
        sensor.setType(updatedSensor.getType());
        sensor.setActive(updatedSensor.isActive());
        return sensorRepository.save(sensor);
    }



    /**
     * Deletes a specific sensor
     */
    public void deleteSensor(Long id) {

        sensorRepository.deleteById(id);
    }
}
