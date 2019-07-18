package com.falcon.tasks.controller;

import com.falcon.tasks.domain.Task;
import com.falcon.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = {"","/"})
    public Iterable<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task) {
        return taskService.save(task);
    }
}
