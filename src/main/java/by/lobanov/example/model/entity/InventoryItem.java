package by.lobanov.example.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("inventory")
public class InventoryItem {

    @Id
    String itemId;
    String name;
    Integer amount;
}
