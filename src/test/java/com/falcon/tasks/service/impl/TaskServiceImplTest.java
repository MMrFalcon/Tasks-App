package com.falcon.tasks.service.impl;

import com.falcon.tasks.domain.Task;
import com.falcon.tasks.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class TaskServiceImplTest {

    private static final Long FIRST_TASK_ID = 1L;
    private static final String FIRST_TASK_NAME = "First Task";
    private static final LocalDate FIRST_TASK_DUE_DATE = LocalDate.now();
    private static final boolean FIRST_TASK_COMPLETED = true;

    private static final Long SECOND_TASK_ID = 2L;
    private static final String SECOND_TASK_NAME = "Second Task";
    private static final LocalDate SECOND_TASK_DUE_DATE = LocalDate.now();
    private static final boolean SECOND_TASK_COMPLETED = false;

    @Mock
    TaskRepository taskRepository;

    private TaskServiceImpl taskService;

    private Set<Task> tasks;
    private Task firstTask;
    private Task secondTask;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        taskService = new TaskServiceImpl(taskRepository);

        firstTask = new Task(FIRST_TASK_ID, FIRST_TASK_NAME, FIRST_TASK_DUE_DATE, FIRST_TASK_COMPLETED);
        secondTask = new Task(SECOND_TASK_ID, SECOND_TASK_NAME, SECOND_TASK_DUE_DATE, SECOND_TASK_COMPLETED);

        tasks = new HashSet<>();
        tasks.add(firstTask);
        tasks.add(secondTask);
    }

    @Test
    public void getTasks() {
        when(taskRepository.findAll()).thenReturn(tasks);

        Iterable<Task> foundTasks = taskService.getTasks();

        assertEquals(tasks.size(), ((Collection<?>) foundTasks).size());
    }

    @Test
    public void save() {
        when(taskRepository.save(firstTask)).thenReturn(firstTask);

        Task savedTask = taskService.save(firstTask);

        assertNotNull(savedTask);
        assertEquals(firstTask.getName(), savedTask.getName());
        assertEquals(firstTask.getDueDate(), savedTask.getDueDate());
        assertEquals(firstTask.isCompleted(), savedTask.isCompleted());

        verify(taskRepository, times(1)).save(firstTask);
    }
}