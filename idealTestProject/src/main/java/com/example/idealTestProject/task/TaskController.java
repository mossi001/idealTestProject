package com.example.idealTestProject.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (path= "api/task")
public class TaskController {

    private final TaskService taskservice;

    @Autowired
    public TaskController(TaskService taskservice){
        this.taskservice = taskservice;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskservice.getTasks();
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task){
        taskservice.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(
            @PathVariable("taskId") Long taskId){
        taskservice.deleteTask(taskId);

    }

    @PutMapping(path = "{taskId}")
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
