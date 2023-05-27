package com.Sahil.Springbootassignment.Service;

import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;

public interface QuizService {

    void createQuiz(QuizRequestDto quizRequestDto);

    QuizResponseDto addQuestion(QuestionRequestDto question);
}
