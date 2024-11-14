package org.example.sensormodule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class SensorServiceTest {

    @Autowired
    private SensorService sensorService;

    @MockBean
    private SensorRepository sensorRepository;


    /**
     * Tests the method createSensor() by generating and saving a new sensor and verifying the result.
     */
    @Test
    public void testCreateSensor() {
        Sensor sensor = new Sensor("Sensor1", "Living Room", true, SensorType.INDOOR);
        when(sensorRepository.save(any(Sensor.class))).thenReturn(sensor);

        Sensor result = sensorService.createSensor(sensor);
        assertNotNull(result);
        assertEquals("Living Room", result.getLocation());
    }

    /**
     * Tests the method deleteSensor() by verifying that sensorService.deleteSensor() is called once.
     */
    @Test
    public void testDeleteSensor() {
        Long sensorId = 1L;
        Sensor sensor = new Sensor("Sensor1", "Living Room", true, SensorType.INDOOR);
        sensor.setId(sensorId);

        when(sensorRepository.findById(sensorId)).thenReturn(Optional.of(sensor));

        sensorService.deleteSensor(sensorId);
        verify(sensorRepository, times(1)).deleteById(sensorId);
    }
}
