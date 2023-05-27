package com.Sahil.Springbootassignment;


import com.Sahil.Springbootassignment.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TaskScheduler {

    @Autowired
    QuizRepository quizRepository;

    @Scheduled(cron = "0 * * * * *") // Runs every minute, adjust the cron expression as needed
    public void updateTaskStatus() {
        List<Task> tasks = taskRepository.findAll();
        LocalDateTime currentDateTime = LocalDateTime.now();

        for (Task task : tasks) {
            if (currentDateTime.isAfter(task.getStartTime()) && currentDateTime.isBefore(task.getEndTime())) {
                task.setActive(true);
            } else {
                task.setActive(false);
            }
        }
    }
}
