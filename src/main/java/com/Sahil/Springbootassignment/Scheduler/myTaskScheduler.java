package com.Sahil.Springbootassignment.Scheduler;


import com.Sahil.Springbootassignment.Entity.Quiz;
import com.Sahil.Springbootassignment.Enum.QuizStatus;
import com.Sahil.Springbootassignment.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class myTaskScheduler {

    @Autowired
    QuizRepository quizRepository;

    @Scheduled(cron = "0 * * * * *") // Runs every minute, adjust the cron expression as needed
    public void updateTaskStatus() {
        List<Quiz> quizzes = quizRepository.findAll();
        LocalDateTime currentDateTime = LocalDateTime.now();

        for (Quiz quiz : quizzes) {
            if(currentDateTime.isBefore(quiz.getStartDateAndTime())) {
                quiz.setQuizStatus(QuizStatus.INACTIVE);
            } else if (currentDateTime.isAfter(quiz.getEndDateAndTime())) {
                quiz.setQuizStatus(QuizStatus.FINISHED);
            } else {
                quiz.setQuizStatus(QuizStatus.ACTIVE);
                quiz.setActive(true);
            }
            quizRepository.save(quiz);
        }
    }
}
