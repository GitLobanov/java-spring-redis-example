package by.lobanov.example.repository;

import by.lobanov.example.model.entity.TemperatureData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemperatureRepository extends CrudRepository<TemperatureData, String> {

    List<TemperatureData> findByValueGreaterThan(double minValue);
    List<TemperatureData> findByValueLessThan(Double value);
    @Override
    List<TemperatureData> findAll();
}
