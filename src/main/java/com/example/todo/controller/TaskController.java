package com.example.todo.controller;

import com.example.todo.domain.Status;
import com.example.todo.domain.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "size", defaultValue = "5") int size,
                            @RequestParam(value = "assignedTo", required = false) String assignedTo,
                            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
                            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) {

        List<Task> tasks = taskService.findFiltered(assignedTo, sortField, sortDir, page, size);
        long totalTasks = taskService.count();
        int totalPages = (int) Math.ceil((double) totalTasks / size);

        model.addAttribute("tasks", tasks);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);

        model.addAttribute("assignedTo", assignedTo);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "task-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("statuses", Status.values());
        return "task-form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("task") @Valid Task task,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("statuses", Status.values());
            return "task-form";
        }
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.findById(id);
        if (task == null) return "redirect:/tasks";
        model.addAttribute("task", task);
        model.addAttribute("statuses", Status.values());
        return "task-form";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") @Valid Task task,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("statuses", Status.values());
            return "task-form";
        }
        taskService.update(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
