package com.example.idealTestProject.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (path= "/api")
public class TaskController {

    private final TaskService taskservice;

    @Autowired
    public TaskController(TaskService taskservice){
        this.taskservice = taskservice;
    }

    @GetMapping (path= "/tasks")
    public List<Task> getTasks(){
        return taskservice.getTasks();
    }

    @PostMapping (path= "/tasks")
    public void addNewTask(@RequestBody Task task){
        taskservice.addNewTask(task);
    }

    @DeleteMapping (path= "/tasks/{id}")
    public void deleteTask(
            @PathVariable("taskId") Long taskId){
        taskservice.deleteTask(taskId);

    }

    @PutMapping (path= "/tasks/{id}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) LocalDate createDate,
            @RequestParam(required = false) LocalDate completeTask){
        taskservice.updateTask(taskId, title, description, completed, createDate, completeTask);

    }



}
