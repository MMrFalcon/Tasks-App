package com.falcon.tasks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Task {

    @GeneratedValue
    private Long id;
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
    private boolean completed;
}
