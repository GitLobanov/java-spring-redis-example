package by.lobanov.example.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("temperature")
@Data
public class TemperatureData {

    @Id
    private String sensorId;
    private Double value;
}
