package com.Sahil.Springbootassignment.Service;

import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;

import java.text.ParseException;
import java.util.List;

public interface QuizService {

    void createQuiz(QuizRequestDto quizRequestDto) throws ParseException;

    QuizResponseDto addQuestion(QuestionRequestDto question) throws Exception;

    List<QuizResponseDto> getActiveQuizzes();
    List<QuizResponseDto> getAllQuizzes();

    List<Object> getResult(Integer id);
}
