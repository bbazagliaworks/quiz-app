package com.thoughtworks.quizapp.services;

import com.thoughtworks.quizapp.entities.Question;
import com.thoughtworks.quizapp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Long quizId, Question question) {
        question.setQuizId(quizId);
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.orElse(null);
    }

    public Question updateQuestion(Long quizId, Long id, Question question) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion == null) {
            return null;
        }
        existingQuestion.setQuizId(quizId);
        existingQuestion.setContent(question.getContent());
        existingQuestion.setType(question.getType());
        return questionRepository.save(existingQuestion);
    }
}