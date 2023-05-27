package com.Sahil.Springbootassignment.Controller;

import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;
import com.Sahil.Springbootassignment.Exception.QuizNotFoundException;
import com.Sahil.Springbootassignment.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping
    public void createQuiz(@RequestBody QuizRequestDto quizRequestDto) throws ParseException {
        quizService.createQuiz(quizRequestDto);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity addQuestion(@RequestBody QuestionRequestDto questionRequestDto) throws QuizNotFoundException {
        QuizResponseDto quizResponseDto = quizService.addQuestion(questionRequestDto);
        return new ResponseEntity<>(quizResponseDto, HttpStatus.ACCEPTED);
    }
}
