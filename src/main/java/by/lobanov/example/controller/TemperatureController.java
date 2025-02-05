package by.lobanov.example.controller;

import by.lobanov.example.model.entity.TemperatureData;
import by.lobanov.example.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/temperature")
@RequiredArgsConstructor
public class TemperatureController {

    private final TemperatureService temperatureService;

    @GetMapping("/temperature/all")
    public ResponseEntity<List<TemperatureData>> getAllTemperatures () {
        return ResponseEntity.ok(temperatureService.getTemperaturesFromAllSenors());
    }

    @GetMapping("/temperature/{sensorId}")
    public ResponseEntity<TemperatureData> getTemperatureBySensor (@PathVariable("sensorId") String idSensor) {
        return ResponseEntity.ok(temperatureService.getCurrentTemperatureBySensor(idSensor));
    }

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureData> saveCurrentTemperatureBySensor (@RequestBody TemperatureData temperatureData) {
        return ResponseEntity.ok(temperatureService.saveOrUpdateTemperature(temperatureData));
    }
}
