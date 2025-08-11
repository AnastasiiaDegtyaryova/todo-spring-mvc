package com.example.todo.service;

import com.example.todo.dao.TaskDAO;
import com.example.todo.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public void save(Task task) {
        taskDAO.save(task);
    }

    @Override
    public void update(Task task) {
        taskDAO.update(task);
    }

    @Override
    public void delete(int id) {
        taskDAO.delete(id);
    }

    @Override
    public Task findById(int id) {
        return taskDAO.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    @Override
    public List<Task> findPaginated(int page, int size) {
        return taskDAO.findPaginated(page, size);
    }

    @Override
    public long count() {
        return taskDAO.count();
    }

    @Override
    public List<Task> findFiltered(String assignedTo, String sortField, String sortDir, int page, int size) {
        return taskDAO.findFiltered(assignedTo, sortField, sortDir, page, size);
    }
}

