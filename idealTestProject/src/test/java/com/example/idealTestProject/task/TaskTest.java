package com.example.idealTestProject.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task = new Task(7L,
            "Cleaning",
            "Read for 3 hours",
            true,
            LocalDate.of(2023, Month.SEPTEMBER, 29),
            LocalDate.of(2023, Month.SEPTEMBER, 30)

    );

    @Test
    void getId() {
        Long idTest = 7L;
        assertEquals(idTest, task.getId());

    }

    @Test
    void getTitle() {
        String clean = "Cleaning";
        assertEquals(clean, task.getTitle());
    }

    @Test
    void getDescription() {
        String descriptionTest = "Read for 3 hours";
        assertEquals(descriptionTest, task.getDescription());
    }

    @Test
    void getCompleted() {
        Boolean completeTest = true;
        assertEquals(completeTest, task.getCompleted());
    }

    @Test
    void getCreateDate() {
        LocalDate createDateTest = LocalDate.of(2023, Month.SEPTEMBER, 29);
        assertEquals(createDateTest, task.getCreateDate());
    }

    @Test
    void getCompletedDate() {
        LocalDate completedDateTest = LocalDate.of(2023, Month.SEPTEMBER, 30);
        assertEquals(completedDateTest, task.getCompletedDate());
    }
}