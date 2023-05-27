package com.Sahil.Springbootassignment.Service.Impl;

import com.Sahil.Springbootassignment.Convertor.QuestionConvertor;
import com.Sahil.Springbootassignment.Convertor.QuizConvertor;
import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuestionResponseDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;
import com.Sahil.Springbootassignment.Entity.Question;
import com.Sahil.Springbootassignment.Entity.Quiz;
import com.Sahil.Springbootassignment.Exception.QuizNotFoundException;
import com.Sahil.Springbootassignment.Repository.QuestionRepository;
import com.Sahil.Springbootassignment.Repository.QuizRepository;
import com.Sahil.Springbootassignment.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void createQuiz(QuizRequestDto quizRequestDto) throws ParseException {
        Quiz quiz = QuizConvertor.QuizRequestDtoToQuiz(quizRequestDto);
        quizRepository.save(quiz);
    }

    @Override
    public QuizResponseDto addQuestion(QuestionRequestDto questionRequestDto) {

        //getting the quiz if present else throwing runtime exception
        Quiz quiz;
        try {
            quiz = quizRepository.findById(questionRequestDto.getQuizId()).get();
        } catch (Exception e) {
            throw new QuizNotFoundException("Quiz not Found");
        }

        //getting the questions list and adding this new question to that list
        List<Question> questions = quiz.getQuestions();
        Question question = QuestionConvertor.questionRequestDtoToQuestion(questionRequestDto);
        questions.add(question);
        question.setQuiz(quiz);
        questionRepository.save(question);

        //returning the quiz details to the client
        return QuizConvertor.quizToQuizResponseDto(quiz);
    }
}
