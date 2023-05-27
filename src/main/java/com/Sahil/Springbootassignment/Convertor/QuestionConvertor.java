package com.Sahil.Springbootassignment.Convertor;

import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuestionResponseDto;
import com.Sahil.Springbootassignment.Entity.Question;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QuestionConvertor {

    public static Question questionRequestDtoToQuestion(QuestionRequestDto questionRequestDto) {
        StringBuilder sb = new StringBuilder();
        for(Object option : questionRequestDto.getOptions()) {
            sb.append(option).append("_");
        }

        return Question.builder()
                .question(questionRequestDto.getQuestion())
                .options(sb.toString())
                .rightAnswer(questionRequestDto.getRightAnswer())
                .build();
    }
}
