package com.example.todo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    @NotNull(message = "Status cannot be null")
    private Status status;

    @Column(name = "assigned_to")
    @NotBlank(message = "Please assign the task to someone")
    private String assignedTo;

    public Task() {
    }

    public Task(String description, Status status, String assignedTo) {
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
    }
}

