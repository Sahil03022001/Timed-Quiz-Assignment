package com.Sahil.Springbootassignment.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponseDto {

    //question name
    private String question;

    //array of answer options for the question
    private List<Object> options;

    //index of correct answer from options array
    private int rightAnswer;
}
