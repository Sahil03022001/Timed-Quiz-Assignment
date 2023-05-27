package com.Sahil.Springbootassignment.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDto {

    private String startDateAndTime;
    private String endDateAndTime;
    private List<QuestionResponseDto> questionResponseList;
}
