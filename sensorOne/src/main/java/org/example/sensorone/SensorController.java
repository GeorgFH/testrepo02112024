package org.example.sensorone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * REST-controller for the administaration of sensors (in our case sensor 1)
 */
@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    /**
     * Returns information about the generated sensor
     * @return
     */
    @GetMapping
    public Sensor getSensor() {
        Sensor sensor = sensorService.getSingleSensor();
        if (sensor == null) {
            System.out.println("No sensor generated");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No sensor generated");
        }
        return sensor;
    }

    /**
     * Creates or updates a sensor
     * @param sensor
     * @return
     */
    @PostMapping
    public Sensor createOrUpdateSensor(@RequestBody Sensor sensor) {
        return sensorService.createOrUpdateSensor(sensor);
    }

    /**
     * Deletes a sensor
     */
    @DeleteMapping
    public void deleteSensor() {
        sensorService.deleteSensor();
    }
}
