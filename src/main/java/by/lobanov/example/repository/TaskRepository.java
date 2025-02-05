package by.lobanov.example.repository;

import by.lobanov.example.model.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public boolean save(Task task) {
        return Optional.ofNullable(redisTemplate.opsForZSet().add("tasks", task, task.getPriority()))
                .orElseThrow(() -> new IllegalArgumentException("Exception in adding new task"));
    }

    public Set<Task> getTaskByRangePriority(Double min, Double max) {
        return Optional.ofNullable(redisTemplate.opsForZSet().rangeByScore("tasks", min, max))
                .map(tasks -> tasks.stream().map(Task.class::cast).collect(Collectors.toSet()))
                .orElseThrow(() -> new IllegalArgumentException("Exception in getting task by range priority"));
    }
}
