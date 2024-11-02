package org.example.sensortwo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MeasurementServiceTest {

    @Autowired
    private MeasurementService measurementService;

    @MockBean
    private MeasurementRepository measurementRepository;

    @Test
    public void testAddMeasurement() {
        Sensor sensor = new Sensor("Sensor2","Living Room", true, SensorType.INDOOR);
        sensor.setId(2L);
        Measurement measurement = new Measurement(sensor, LocalDateTime.now(), 20.5, 65.0);
        when(measurementRepository.save(any(Measurement.class))).thenReturn(measurement);

        Measurement result = measurementService.addMeasurement(measurement);
        assertNotNull(result);
        assertEquals(20.5, result.getTemperature());
    }

    @Test
    public void testGetMeasurementsBySensorId() {
        Sensor sensor = new Sensor("Sensor2","Living Room", true, SensorType.INDOOR);
        sensor.setId(2L);
        Measurement measurement1 = new Measurement(sensor,LocalDateTime.now(), 20.5, 65.0);
        Measurement measurement2 = new Measurement(sensor, LocalDateTime.now(), 22.3, 70.0);

        when(measurementRepository.findBySensorId(1L)).thenReturn(List.of(measurement1, measurement2));

        List<Measurement> results = measurementService.getMeasurementsBySensorId(1L);
        assertEquals(2, results.size());
    }
}

