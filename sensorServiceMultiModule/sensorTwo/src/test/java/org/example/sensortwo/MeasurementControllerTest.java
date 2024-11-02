package org.example.sensortwo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurementController.class)
public class MeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Tests the delete method of the controller
     */
    @Test
    public void testDeleteMeasurement() throws Exception {
        doNothing().when(measurementService).deleteMeasurement(2L);

        mockMvc.perform(delete("/measurements/2"))
                .andExpect(status().isOk());

        verify(measurementService, times(1)).deleteMeasurement(2L);
    }
}