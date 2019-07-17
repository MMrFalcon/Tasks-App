package com.falcon.tasks.controller;

import com.falcon.tasks.domain.Task;
import com.falcon.tasks.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TaskControllerTest {

    private static final Long FIRST_TASK_ID = 1L;
    private static final String FIRST_TASK_NAME = "First Task";
    private static final LocalDate FIRST_TASK_DUE_DATE = LocalDate.now();
    private static final boolean FIRST_TASK_COMPLETED = true;

    private static final Long SECOND_TASK_ID = 2L;
    private static final String SECOND_TASK_NAME = "Second Task";
    private static final LocalDate SECOND_TASK_DUE_DATE = LocalDate.now();
    private static final boolean SECOND_TASK_COMPLETED = false;

    @Mock
    TaskService taskService;

    private TaskController taskController;
    private MockMvc mockMvc;
    private Set<Task> tasks;
    private Task firstTask;
    private Task secondTask;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        taskController = new TaskController(taskService);

        firstTask = new Task(FIRST_TASK_ID, FIRST_TASK_NAME, FIRST_TASK_DUE_DATE, FIRST_TASK_COMPLETED);
        secondTask = new Task(SECOND_TASK_ID, SECOND_TASK_NAME, SECOND_TASK_DUE_DATE, SECOND_TASK_COMPLETED);

        tasks = new HashSet<>();
        tasks.add(firstTask);
        tasks.add(secondTask);

        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void getTasks() throws Exception {
        when(taskService.getTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(SECOND_TASK_NAME)))
                .andExpect(jsonPath("$[1].name", is(FIRST_TASK_NAME)));

        verify(taskService, times(1)).getTasks();

    }
}