package by.lobanov.example.model.entity;

import by.lobanov.example.model.constant.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Task {

    String idTask;
    String name;
    String description;
    LocalDateTime dateTimeCompleted;
    TaskStatus status;
    Double priority;
}
