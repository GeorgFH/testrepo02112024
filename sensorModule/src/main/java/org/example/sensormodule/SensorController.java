package org.example.sensormodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-controller for the administration of sensors
 */
@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorService sensorService;



    /**
     * Post endpoint to create a new sensor
     * @param sensor
     * @return
     */
    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }


    /**
     * Get endpoint that returns all generated sensors
     * @return
     */
    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    /**
     * Get endpoint that returns a specific sensor
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id);
    }


    /**
     * Put endpoint that updates a specific sensor
     * @param id
     * @param updatedSensor
     * @return
     */
    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id, @RequestBody Sensor updatedSensor) {
        return sensorService.updateSensor(id, updatedSensor);
    }

    /**
     * Deletes a specific sensor
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
    }
}
