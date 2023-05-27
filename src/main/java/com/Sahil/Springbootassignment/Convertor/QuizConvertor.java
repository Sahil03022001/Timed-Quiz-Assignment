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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UtilityClass
public class QuizConvertor {

    //building object of Quiz
    public static Quiz QuizRequestDtoToQuiz(QuizRequestDto quizRequestDto) throws ParseException {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        String dateString = "2023-05-26";
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        Date date = sdf.parse(dateString);
//        String cronExpression = convertToCronExpression(date);
//        String[] startArr = quizRequestDto.getStartDateAndTime().split(" ");
//        String startDateString = startArr[0];
//        String startTimeString = startArr[1];
//
//        String[] endArr = quizRequestDto.getStartDateAndTime().split(" ");
//        String endDateString = endArr[0];
//        String endTimeString = endArr[1];

        String dateString = "2023-05-26 10:30:45";
        String pattern = "yyyy-MM-dd HH:mm:ss";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);


        if (currentDateTime.isAfter(quizRequestDto.getStartDateAndTime()) && currentDateTime.isBefore(quizRequestDto.getEndDateAndTime())) {
            task.setActive(true);
        } else {
            task.setActive(false);
        }
        return Quiz.builder()
                .startDateAndTime(quizRequestDto.getStartDateAndTime())
                .endDateAndTime(quizRequestDto.getEndDateAndTime())
                .build();
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
                .startDateAndTime(quiz.getStartDateAndTime())
                .endDateAndTime(quiz.getEndDateAndTime())
                .questionResponseList(questionResponseDtos)
                .build();
    }
}
