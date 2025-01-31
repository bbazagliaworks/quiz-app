package com.thoughtworks.quizapp.services;

import com.thoughtworks.quizapp.entities.Quiz;
import com.thoughtworks.quizapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz updateQuiz(long id, Quiz quiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz == null) {
            return null;
        }
        existingQuiz.setTitle(quiz.getTitle());
        existingQuiz.setDescription(quiz.getDescription());
        existingQuiz.setIsActive(quiz.getIsActive());

        return quizRepository.save(existingQuiz);
    }

}