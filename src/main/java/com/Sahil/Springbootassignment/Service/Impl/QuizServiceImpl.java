package com.Sahil.Springbootassignment.Service.Impl;

import com.Sahil.Springbootassignment.Convertor.QuestionConvertor;
import com.Sahil.Springbootassignment.Convertor.QuizConvertor;
import com.Sahil.Springbootassignment.DTO.QuestionRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizRequestDto;
import com.Sahil.Springbootassignment.DTO.QuizResponseDto;
import com.Sahil.Springbootassignment.Entity.Question;
import com.Sahil.Springbootassignment.Entity.Quiz;
import com.Sahil.Springbootassignment.Exception.QuizNotFoundException;
import com.Sahil.Springbootassignment.Repository.QuestionRepository;
import com.Sahil.Springbootassignment.Repository.QuizRepository;
import com.Sahil.Springbootassignment.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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
    public QuizResponseDto addQuestion(QuestionRequestDto questionRequestDto) throws Exception {

        //getting the quiz if present else throwing runtime exception
        Quiz quiz;
        try {
            quiz = quizRepository.findById(questionRequestDto.getQuizId()).get();
        } catch (Exception e) {
            throw new QuizNotFoundException("Quiz not Found");
        }

        if(questionRequestDto.getRightAnswer() >= questionRequestDto.getOptions().size()
        || questionRequestDto.getRightAnswer() < 0) {
            throw new Exception("Wrong Index Of Right Answer");
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

    @Override
    public List<QuizResponseDto> getActiveQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<QuizResponseDto> quizResponseDtoList = new ArrayList<>();
        for(Quiz quiz : quizzes) {
            if(quiz.isActive()) {
                QuizResponseDto quizResponseDto = QuizConvertor.quizToQuizResponseDto(quiz);
                quizResponseDtoList.add(quizResponseDto);
            }
        }
        return quizResponseDtoList;
    }

    //done caching in get all quizzes (287ms -> 11ms)
    @Override
    @Cacheable("myCache")
    public List<QuizResponseDto> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<QuizResponseDto> quizResponseDtoList = new ArrayList<>();
        for(Quiz quiz : quizzes) {
            QuizResponseDto quizResponseDto = QuizConvertor.quizToQuizResponseDto(quiz);
            quizResponseDtoList.add(quizResponseDto);
        }
        return quizResponseDtoList;
    }

    @Override
    public List<Object> getResult(Integer id) {
        Quiz quiz;
        try {
            quiz = quizRepository.findById(id).get();
        } catch (QuizNotFoundException e) {
            throw new QuizNotFoundException("Quiz not Found");
        }

        List<Object> result = new ArrayList<>();
        List<Question> questions = quiz.getQuestions();
        for(Question question : questions) {
            int ri = question.getRightAnswer();
            String[] arr = question.getOptions().split("_");
            result.add(arr[ri]);
        }

        return result;
    }
}
