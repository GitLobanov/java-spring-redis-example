package by.lobanov.example.repository;

import by.lobanov.example.model.entity.InventoryItem;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<InventoryItem, String> {
}
