package com.thoughtworks.quizapp;


import com.thoughtworks.quizapp.entities.Question;
import com.thoughtworks.quizapp.repositories.QuestionRepository;
import com.thoughtworks.quizapp.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTests {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void shouldCreateQuestion() {
        Question question = new Question();
        question.setContent("Can you say Hello World?");
        question.setType("text");

        when(questionRepository.save(any(Question.class))).thenReturn(question);

        Question createdQuestion = questionService.createQuestion(1L, question);

        assertThat(createdQuestion.getContent()).isEqualTo("Can you say Hello World?");
        assertThat(createdQuestion.getType()).isEqualTo("text");
    }
}
