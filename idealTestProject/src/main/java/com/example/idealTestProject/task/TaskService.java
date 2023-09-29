package com.example.idealTestProject.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();

    }

    public void addNewTask(Task task){
        Optional<Task> studentOptional =
                taskRepository.findTaskById(task.getId());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("id taken");
        }
        taskRepository.save(task);
        System.out.println(task);
    }

    public void deleteTask(Long taskId){
        boolean exists = taskRepository.existsById(taskId);
        if (!exists){
            throw new IllegalStateException(
                    "task with id " + taskId + " does not exist");
        }
        taskRepository.deleteById(taskId);

    }

    @Transactional
    public void updateTask(Long taskId,
                              String title,
                              String description,
                              Boolean completed,
                              LocalDate createDate,
                              LocalDate completedDate){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "task with id " + taskId + " does not exist"));
        if (title != null &&
                title.length() > 0 &&
                !Objects.equals(task.getTitle(), title)){
            task.setTitle(title);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(task.getDescription(), description)) {
            Optional<Task> studentOptional = taskRepository.findTaskById(taskId);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("id taken");

            }
            task.setDescription(description);

        }
        if(completed != null)
        {
            task.setCompleted(completed);
        }

        if (createDate != null)
        {
            task.setCreateDate(createDate);
        }

        if(completedDate != null)
        {
            task.setCompletedDate(completedDate);
        }


    }


}
