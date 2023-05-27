package com.Sahil.Springbootassignment.Entity;

import com.Sahil.Springbootassignment.DTO.QuestionResponseDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    private boolean isActive;

    //list of questions
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    List<Question> questions = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(int id, LocalDateTime startDateAndTime, LocalDateTime endDateAndTime, boolean isActive, List<Question> questions) {
        this.id = id;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.isActive = isActive;
        this.questions = questions;
    }
}
