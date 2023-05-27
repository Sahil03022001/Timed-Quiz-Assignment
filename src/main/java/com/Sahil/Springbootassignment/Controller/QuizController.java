package com.Sahil.Springbootassignment.Controller;

import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;
import com.Sahil.Springbootassignment.Exception.QuizNotFoundException;
import com.Sahil.Springbootassignment.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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
    public ResponseEntity addQuestion(@RequestBody QuestionRequestDto questionRequestDto) throws Exception {
        QuizResponseDto quizResponseDto = quizService.addQuestion(questionRequestDto);
        return new ResponseEntity<>(quizResponseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/active")
    public ResponseEntity getActiveQuizzes() {
        List<QuizResponseDto> quizResponseDtoList = quizService.getActiveQuizzes();
        return new ResponseEntity<>(quizResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllQuizzes() {
        List<QuizResponseDto> quizResponseDtoList = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}/result")
    public ResponseEntity getResult(@PathVariable Integer id) {
        List<Object> result = quizService.getResult(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
