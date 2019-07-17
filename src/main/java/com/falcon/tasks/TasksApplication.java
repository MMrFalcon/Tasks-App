package com.falcon.tasks;

import com.falcon.tasks.domain.Task;
import com.falcon.tasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TaskService taskService){
        return args -> {
            taskService.save(new Task(1L, "Create project", LocalDate.now().plusDays(2L), true));
            taskService.save(new Task(2L, "Add packages and data", LocalDate.now().plusDays(3L),false));
            taskService.save(new Task(3L, "Test your data", LocalDate.now().plusDays(3L), false));
            taskService.save(new Task(4L, "Deploy application", LocalDate.now().plusDays(4L), false));
        };
    }

}
