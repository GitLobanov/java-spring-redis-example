package by.lobanov.example.controller;

import by.lobanov.example.model.dto.SuccessMessageResponseDto;
import by.lobanov.example.model.entity.Task;
import by.lobanov.example.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("schedule/")
@RequiredArgsConstructor
public class ScheduleController {

    private final TaskRepository taskRepository;

    @PostMapping("")
    public ResponseEntity<SuccessMessageResponseDto> createTask (@RequestBody Task task) {
        taskRepository.save(task);
        return ResponseEntity.ok(SuccessMessageResponseDto.builder().message("Task created").build());
    }

    @GetMapping("/byRangePriority")
    public ResponseEntity<Set<Task>> getByRangePriority (@RequestParam Double max, @RequestParam Double min) {
        return ResponseEntity.ok(taskRepository.getTaskByRangePriority(max, min));
    }
}
