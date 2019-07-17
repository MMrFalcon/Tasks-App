package com.falcon.tasks.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TaskTest {

    private static final Long TASK_ID = 12L;
    private static final String TASK_NAME = "Do something";
    private static final LocalDate TASK_DUE_DATE = LocalDate.now();
    private static final boolean TASK_COMPLETED = true;

    private Task task;

    @Before
    public void setUp() throws Exception {
        task = new Task(TASK_ID, TASK_NAME, TASK_DUE_DATE, TASK_COMPLETED);
    }

    @Test
    public void getId() {
        assertEquals(TASK_ID, task.getId());
    }

    @Test
    public void getName() {
        assertEquals(TASK_NAME, task.getName());
    }

    @Test
    public void getDueDate() {
        assertEquals(TASK_DUE_DATE, task.getDueDate());
    }

    @Test
    public void isCompleted() {
        assertEquals(TASK_COMPLETED, task.isCompleted());
        assertTrue(task.isCompleted());
    }

    @Test
    public void setId() {
        Long newTaskId = 1L;
        task.setId(newTaskId);
        assertEquals(newTaskId, task.getId());
    }

    @Test
    public void setName() {
        String newTaskName = "New name";
        task.setName(newTaskName);
        assertEquals(newTaskName, task.getName());
    }

    @Test
    public void setDueDate() {
        LocalDate newTaskDueDate = LocalDate.of(2019,6, 1);
        task.setDueDate(newTaskDueDate);
        assertEquals(newTaskDueDate, task.getDueDate());
    }

    @Test
    public void setCompleted() {
        boolean newTaskCompleted = false;
        task.setCompleted(newTaskCompleted);
        assertEquals(newTaskCompleted, task.isCompleted());
        assertFalse(task.isCompleted());
    }
}