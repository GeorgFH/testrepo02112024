package org.example.sensortwo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SensorServiceTest {

    @Autowired
    private SensorService sensorService;

    @MockBean
    private SensorRepository sensorRepository;


    /**
     * Tests the method createOrUpdateSensor() by generating and saving a new sensor and verifying the result.
     */
    @Test
    public void testCreateOrUpdateSensor() {
        Sensor sensor = new Sensor("Sensor2", "Living Room", true, SensorType.INDOOR);
        when(sensorRepository.save(any(Sensor.class))).thenReturn(sensor);

        Sensor result = sensorService.createOrUpdateSensor(sensor);
        assertNotNull(result);
        assertEquals("Living Room", result.getLocation());
    }

    /**
     * Tests the method getSingleSensor() by calling a sensor wit the ID 2 and mocking the behavior of the repository to guarantee that the sensor if correctly found and returned.
     */
    @Test
    public void testGetSingleSensor() {
        Sensor sensor = new Sensor("Sensor2", "Living Room", true, SensorType.INDOOR);
        sensor.setId(2L);

        when(sensorRepository.existsById(2L)).thenReturn(true);
        when(sensorRepository.findById(2L)).thenReturn(Optional.of(sensor));

        Sensor result = sensorService.getSingleSensor();

        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals("Sensor2", result.getName());
    }

    /**
     * Tests the method deleteSensor() by verifying that sensorService.deleteSensor() is called once.
     */
    @Test
    public void testDeleteSensor() {
        sensorService.deleteSensor();
        verify(sensorRepository, times(1)).deleteAll();
    }
}
