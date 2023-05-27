package com.Sahil.Springbootassignment.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequestDto {

    private String startDateAndTime;
    private String endDateAndTime;
}
