package com.thoughtworks.quizapp.controllers;

import com.thoughtworks.quizapp.entities.Question;
import com.thoughtworks.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/{quizId}")
    public void createQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        questionService.createQuestion(quizId, question);
    }

    @PostMapping("/update/{quizId}")
    public void updateQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        questionService.updateQuestion(quizId, question.getId(), question);
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}