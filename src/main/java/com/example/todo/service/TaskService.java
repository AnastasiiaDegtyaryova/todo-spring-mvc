package com.example.todo.service;

import com.example.todo.domain.Task;

import java.util.List;

public interface TaskService {
    void save(Task task);
    void update(Task task);
    void delete(int id);
    Task findById(int id);
    List<Task> findAll();
    List<Task> findPaginated(int page, int size);
    long count();
    List<Task> findFiltered(String assignedTo, String sortField, String sortDir, int page, int size);
}
