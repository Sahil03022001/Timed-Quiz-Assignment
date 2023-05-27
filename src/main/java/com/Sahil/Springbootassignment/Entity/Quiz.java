package com.Sahil.Springbootassignment.Entity;

import com.Sahil.Springbootassignment.DTO.QuestionResponseDto;
import com.Sahil.Springbootassignment.Enum.QuizStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Quiz {

    //primary key of Quiz
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    //start date and time of the quiz
    private LocalDateTime startDateAndTime;

    //end date and time of the quiz
    private LocalDateTime endDateAndTime;

    private boolean isActive = false;

    @Enumerated(EnumType.STRING)
    private QuizStatus quizStatus;

    //list of questions
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    List<Question> questions = new ArrayList<>();

    public void setStartDateAndTime(String startDateAndTime) {
//        String dateString = "2023-05-26 10:30:45";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.startDateAndTime = LocalDateTime.parse(startDateAndTime, formatter);
    }

    public void setEndDateAndTime(String endDateAndTime) {
//        String dateString = "2023-05-26 10:30:45";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.endDateAndTime = LocalDateTime.parse(endDateAndTime, formatter);
    }
}
