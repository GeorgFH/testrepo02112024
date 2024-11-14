package org.example.sensormodule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SensorController.class)
public class SensorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SensorService sensorService;


    /**
     * Tests the getSensor() method of the sensor controller by checking the returning of specific sensor information after generating a new sensor
     * @throws Exception
     */


    /**
     * Tests the createSensor() method of the sensor controller by checking the returning of specific sensor information after generating a new sensor
     * @throws Exception
     */
    @Test
    public void testCreateSensor() throws Exception {
        Sensor sensor = new Sensor("Sensor1","Living Room", true, SensorType.INDOOR);
        when(sensorService.createSensor(any(Sensor.class))).thenReturn(sensor);

        mockMvc.perform(post("/sensor")
                        .contentType("application/json")
                        .content("{\"location\":\"Living Room\",\"active\":true,\"type\":\"INDOOR\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("Living Room"));
    }
}
