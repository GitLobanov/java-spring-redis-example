package by.lobanov.example.service;

import by.lobanov.example.model.entity.TemperatureData;
import by.lobanov.example.repository.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;

    public TemperatureData saveTemperature(TemperatureData temperatureData) {
        return temperatureRepository.save(temperatureData);
    }

    public TemperatureData getCurrentTemperatureBySensor(String sensorId) {
        return temperatureRepository.findById(sensorId).
                orElseThrow(() -> new IllegalArgumentException(String.format("We can't find temperature for this sensor: %s", sensorId)));
    }

    public TemperatureData saveOrUpdateTemperature(TemperatureData temperatureData) {
        TemperatureData data = temperatureRepository.findById(temperatureData.getSensorId())
                .orElse(new TemperatureData());
        data.setSensorId(temperatureData.getSensorId());
        data.setValue(temperatureData.getValue());
        return temperatureRepository.save(data);
    }

    public List<TemperatureData> getTemperaturesFromAllSenors() {
        return temperatureRepository.findAll();
    }
}
