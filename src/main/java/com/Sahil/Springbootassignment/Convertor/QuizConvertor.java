package com.Sahil.Springbootassignment.Convertor;

import com.Sahil.Springbootassignment.DTO.QuestionResponseDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;
import com.Sahil.Springbootassignment.Entity.Question;
import com.Sahil.Springbootassignment.Entity.Quiz;
import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UtilityClass
public class QuizConvertor {

    //building object of Quiz
    public static Quiz QuizRequestDtoToQuiz(QuizRequestDto quizRequestDto) throws ParseException {
        Quiz quiz = new Quiz();
        quiz.setStartDateAndTime(quizRequestDto.getStartDateAndTime());
        quiz.setEndDateAndTime(quizRequestDto.getEndDateAndTime());
        return quiz;
    }

    //Builds an object of QuizResponseDto
    public static QuizResponseDto quizToQuizResponseDto(Quiz quiz) {

        //getting the questions list
        List<Question> questionList = quiz.getQuestions();

        //creating questionResponseDto arraylist
        List<QuestionResponseDto> questionResponseDtos = new ArrayList<>();

        //iterating in questions list and making object of QuestionResponseDto and adding it to the required list
        for(Question question : questionList) {
            QuestionResponseDto questionResponseDto = new QuestionResponseDto();
            questionResponseDto.setQuestion(question.getQuestion());
            questionResponseDto.setRightAnswer(question.getRightAnswer());

            //converting string to a list to show to the client in the same way client gave the options
            questionResponseDto.setOptions(List.of(question.getOptions().split("_")));
            questionResponseDtos.add(questionResponseDto);
        }

        return QuizResponseDto.builder()
                .startDateAndTime(quiz.getStartDateAndTime().toString())
                .endDateAndTime(quiz.getEndDateAndTime().toString())
                .isActive(quiz.isActive())
                .questionResponseList(questionResponseDtos)
                .build();
    }
}
