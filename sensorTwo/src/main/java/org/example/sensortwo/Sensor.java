package org.example.sensortwo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Schema(description = "Sensor entity representing a physical sensor device")
public class Sensor {

    @Id
    @Schema(description = "Unique identifier of the sensor", example = "2")
    private Long id;

    @Schema(description = "Name of the sensor", example = "Sensor2")
    private String name;

    @Schema(description = "Location where the sensor is placed", example = "Bed Room")
    private String location;

    @Schema(description = "Indicates whether the sensor is active", example = "true")
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Type of sensor (e.g., INDOOR, OUTDOOR)", example = "OUTDOOR")
    private SensorType type;

    public Sensor() {}

    public Sensor(String name, String location, boolean active, SensorType type) {
        this.name = name;
        this.location = location;
        this.active = active;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }
}
