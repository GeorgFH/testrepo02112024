package org.example.sensorone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class SensorOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorOneApplication.class, args);
    }

}
