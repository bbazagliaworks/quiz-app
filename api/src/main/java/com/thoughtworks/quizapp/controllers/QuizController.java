package com.thoughtworks.quizapp.controllers;

import com.thoughtworks.quizapp.entities.Quiz;
import com.thoughtworks.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @PostMapping("/update")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return quizService.updateQuiz(quiz.getId(), quiz);
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable long id) {
        return quizService.getQuizById(id);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
}