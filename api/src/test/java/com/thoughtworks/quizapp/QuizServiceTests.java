package com.thoughtworks.quizapp;

import com.thoughtworks.quizapp.entities.Quiz;
import com.thoughtworks.quizapp.repositories.QuizRepository;
import com.thoughtworks.quizapp.services.QuizService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTests {

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizService quizService;

    @Test
    void ShouldCreateQuiz() {
        Quiz quiz = new Quiz();
        quiz.setOwnerId(1);
        quiz.setTitle("Sample Quiz");

        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz createdQuiz = quizService.createQuiz(quiz);

        assertThat(createdQuiz).isNotNull();
        assertThat(createdQuiz.getTitle()).isEqualTo("Sample Quiz");
        assertThat(createdQuiz.getOwnerId()).isEqualTo(1);
    }
}
