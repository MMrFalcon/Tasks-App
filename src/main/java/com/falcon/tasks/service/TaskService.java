package com.falcon.tasks.service;

import com.falcon.tasks.domain.Task;

public interface TaskService {

    Iterable<Task> getTasks();
    Task save(Task task);
}
