package org.example.sensorone;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        doNothing().when(measurementService).deleteMeasurement(1L);

        mockMvc.perform(delete("/measurements/1"))
                .andExpect(status().isOk());

        verify(measurementService, times(1)).deleteMeasurement(1L);
    }
}