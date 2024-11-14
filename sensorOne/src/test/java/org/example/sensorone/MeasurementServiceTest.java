package org.example.sensorone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MeasurementServiceTest {

    @Autowired
    private MeasurementService measurementService;

    @MockBean
    private MeasurementRepository measurementRepository;

    @Test
    public void testAddMeasurement() {
        Sensor sensor = new Sensor("Sensor1","Living Room", true, SensorType.INDOOR);
        sensor.setId(1L);
        Measurement measurement = new Measurement(sensor, LocalDateTime.now(), 20.5, 65.0);
        when(measurementRepository.save(any(Measurement.class))).thenReturn(measurement);

        Measurement result = measurementService.addMeasurement(measurement);
        assertNotNull(result);
        assertEquals(20.5, result.getTemperature());
    }

    @Test
    public void testGetMeasurementsBySensorId() {
        Sensor sensor = new Sensor("Sensor1","Living Room", true, SensorType.INDOOR);
        sensor.setId(1L);
        Measurement measurement1 = new Measurement(sensor,LocalDateTime.now(), 20.5, 65.0);
        Measurement measurement2 = new Measurement(sensor, LocalDateTime.now(), 22.3, 70.0);

        when(measurementRepository.findBySensorId(1L)).thenReturn(List.of(measurement1, measurement2));

        List<Measurement> results = measurementService.getMeasurementsBySensorId(1L);
        assertEquals(2, results.size());
    }
}
