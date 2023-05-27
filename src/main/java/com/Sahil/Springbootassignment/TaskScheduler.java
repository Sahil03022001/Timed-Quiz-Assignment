package com.Sahil.Springbootassignment;


import com.Sahil.Springbootassignment.Entity.Quiz;
import com.Sahil.Springbootassignment.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TaskScheduler {

    @Autowired
    QuizRepository quizRepository;

    @Scheduled(cron = "0 * * * * *") // Runs every minute, adjust the cron expression as needed
    public void updateTaskStatus() {
        List<Quiz> quizzes = quizRepository.findAll();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
//        System.out.println(currentDateTime);

        for (Quiz quiz : quizzes) {
            quiz.setActive(currentDateTime.isAfter(quiz.getStartDateAndTime()) && currentDateTime.isBefore(quiz.getEndDateAndTime()));
            quizRepository.save(quiz);
        }
    }
}
