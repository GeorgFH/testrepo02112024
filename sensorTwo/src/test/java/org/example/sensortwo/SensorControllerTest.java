package org.example.sensortwo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @Test
    public void testGetSensor() throws Exception {
        Sensor sensor = new Sensor("Sensor2","Living Room", true, SensorType.INDOOR);
        sensor.setId(1L);
        when(sensorService.getSingleSensor()).thenReturn(sensor);

        mockMvc.perform(get("/sensor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("Living Room"));
    }


    /**
     * Tests the createOrUpdateSensor() method of the sensor controller by checking the returning of specific sensor information after generating a new sensor
     * @throws Exception
     */
    @Test
    public void testCreateOrUpdateSensor() throws Exception {
        Sensor sensor = new Sensor("Sensor2","Living Room", true, SensorType.INDOOR);
        when(sensorService.createOrUpdateSensor(any(Sensor.class))).thenReturn(sensor);

        mockMvc.perform(post("/sensor")
                        .contentType("application/json")
                        .content("{\"location\":\"Living Room\",\"active\":true,\"type\":\"INDOOR\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("Living Room"));
    }
}
