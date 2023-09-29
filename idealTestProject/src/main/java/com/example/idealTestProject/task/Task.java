package com.example.idealTestProject.task;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Task {

    @Id
    private Long id;

    private String title;
    private String description;
    private Boolean completed;
    private LocalDate createDate;
    private LocalDate completedDate;



    public Task(){

    }
    public Task(Long id, String title, String description, Boolean completed, LocalDate createDate, LocalDate completedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createDate = createDate;
        this.completedDate = completedDate;
    }

    @Override
    public String toString(){
        return "Task{" +
                "id=" + id +
                "title'" + title + '\'' +
                "description'" +  description + '\'' +
                "completed" + completed +
                "createDate" + createDate +
                "completedDate" + completedDate;

    }


}
