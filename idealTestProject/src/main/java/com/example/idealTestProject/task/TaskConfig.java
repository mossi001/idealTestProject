package com.example.idealTestProject.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {
        return arg->{
            Task read = new Task(
                    1L,
                    "Reading",
                    "Read for 2 hours",
                    true,
                    LocalDate.of(2023, Month.SEPTEMBER, 29),
                    LocalDate.of(2023, Month.SEPTEMBER, 29)

            );
            Task dishes = new Task(
                    2L,
                    "Dishes",
                    "Wash for 1 hour",
                    true,
                    LocalDate.of(2023, Month.SEPTEMBER, 29),
                    LocalDate.of(2023, Month.SEPTEMBER, 29)

            );
            Task laundry = new Task(
                    3L,
                    "Laundry",
                    "Laundry for 1 hour",
                    true,
                    LocalDate.of(2023, Month.SEPTEMBER, 29),
                    LocalDate.of(2023, Month.SEPTEMBER, 29)

            );
            Task sweep = new Task(
                    4L,
                    "Sweeping",
                    "Laundry for 30 min",
                    true,
                    LocalDate.of(2023, Month.SEPTEMBER, 29),
                    LocalDate.of(2023, Month.SEPTEMBER, 29)

            );
            Task mop = new Task(
                    5L,
                    "Mop",
                    "Mop for 30 min",
                    true,
                    LocalDate.of(2023, Month.SEPTEMBER, 29),
                    LocalDate.of(2023, Month.SEPTEMBER, 29)

            );
            repository.saveAll(
                    List.of(read, dishes, laundry, sweep, mop)
            );


        };

    }

}
