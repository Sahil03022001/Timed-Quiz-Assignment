package com.Sahil.Springbootassignment.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDto {

    //add question to the quiz of this id
    private int quizId;

    //question name
    private String question;

    //array of answer options for the question
    private List<Object> options;

    //index of correct answer from options array
    private int rightAnswer;
}
