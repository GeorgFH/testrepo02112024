package org.example.sensormodule;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Schema(description = "Measurement entity representing a data reading from a sensor")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the measurement", example = "1")
    private Long id;

    @Schema(description = "Timestamp of when the measurement was taken", example = "2024-11-01T10:00:00")
    private LocalDateTime timestamp;

    @Schema(description = "Temperature reading from the sensor in degrees Celsius", example = "23.5")
    private double temperature;

    @Schema(description = "Humidity reading from the sensor as a percentage", example = "45.2")
    private double humidity;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    @Schema(description = "The sensor that recorded this measurement")
    private Sensor sensor;
    
    public Measurement() {}

    public Measurement(Sensor sensor, LocalDateTime timestamp, double temperature, double humidity) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
