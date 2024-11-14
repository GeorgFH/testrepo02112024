package org.example.sensortwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST-controller for the administration of measurements
 */
@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    /**
     * Adds a new measurement
     * @param measurement
     * @return
     */
    @PostMapping
    public Measurement addMeasurement(@RequestBody Measurement measurement) {
        return measurementService.addMeasurement(measurement);
    }

    /**
     * Returns all measurements of a specific sensor
     * @param sensorId
     * @return list of measurements of the specific sensor
     */
    @GetMapping("/sensor/{sensorId}")
    public List<Measurement> getMeasurementsBySensorId(@PathVariable Long sensorId) {
        return measurementService.getMeasurementsBySensorId(sensorId);
    }

    /**
     * Updates a specific measurement
     * @param id
     * @param newMeasurement
     * @return returns the new measurement
     */
    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable Long id, @RequestBody Measurement newMeasurement) {
        Measurement updatedMeasurement = measurementService.updateMeasurement(id, newMeasurement);
        if (updatedMeasurement == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedMeasurement);
        }
    }
    /**
     * Deletes a specific measurement
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
    }

    /**
     * Deletes all measurements of a specific sensor
     */
    @DeleteMapping("/sensor/{sensorId}")
    public void deleteMeasurementsBySensorId(@PathVariable Long sensorId) {
        measurementService.deleteMeasurementsBySensorId(sensorId);
    }
}
