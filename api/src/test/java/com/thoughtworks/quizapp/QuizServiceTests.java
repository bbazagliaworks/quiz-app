package com.thoughtworks.quizapp;

import com.thoughtworks.quizapp.entities.Quiz;
import com.thoughtworks.quizapp.repositories.QuizRepository;
import com.thoughtworks.quizapp.services.QuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

// @ExtendWith(MockitoExtension.class)
public class QuizServiceTests {

    @BeforeEach
    void setUp() {
        quizService = new QuizService();
        quizRepository = mock(QuizRepository.class);
    }

    //@Mock
    private QuizRepository quizRepository;

   // @InjectMocks
    private QuizService quizService;

    @Test
    void ShouldCreateQuiz() {
        Quiz quiz = new Quiz();
        quiz.setOwnerId(1L);
        quiz.setTitle("Sample Quiz");

        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz createdQuiz = quizService.createQuiz(quiz);

        assertThat(createdQuiz).isNotNull();
        assertThat(createdQuiz.getTitle()).isEqualTo("Sample Quiz");
        assertThat(createdQuiz.getOwnerId()).isEqualTo(1L);
    }

    @Test
    void ShouldGetQuizById() {
        Quiz quiz = new Quiz();
        quiz.setOwnerId(1L);
        quiz.setTitle("Sample Quiz");

        when(quizRepository.findById(1L)).thenReturn(java.util.Optional.of(quiz));

        Quiz foundQuiz = quizService.getQuizById(1L);

        assertThat(foundQuiz).isNotNull();
        assertThat(foundQuiz.getTitle()).isEqualTo("Sample Quiz");
        assertThat(foundQuiz.getOwnerId()).isEqualTo(1L);
    }

    @Test
    void ShouldReturnNullIfQuizNotFound() {
        when(quizRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        Quiz foundQuiz = quizService.getQuizById(1L);

        assertThat(foundQuiz).isNull();
    }

    @Test
    void ShouldGetAllQuizzes() {
        Quiz quiz1 = new Quiz();
        quiz1.setOwnerId(1L);
        quiz1.setTitle("Sample Quiz 1");

        Quiz quiz2 = new Quiz();
        quiz2.setOwnerId(1L);
        quiz2.setTitle("Sample Quiz 2");

        when(quizRepository.findAll()).thenReturn(java.util.List.of(quiz1, quiz2));

        assertThat(quizService.getAllQuizzes()).hasSize(2);
    }

    @Test
    void ShouldReturnNullIfNoQuizzesExist() {
        when(quizRepository.findAll()).thenReturn(java.util.List.of());

        assertThat(quizService.getAllQuizzes()).isEmpty();
    }

    @Test
    void ShouldUpdateQuiz() {
        Quiz quiz = new Quiz();
        quiz.setOwnerId(1L);
        quiz.setTitle("Updated Quiz");

        when(quizRepository.findById(1L)).thenReturn(java.util.Optional.of(quiz));
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz updatedQuiz = quizService.updateQuiz(1L, quiz);

        assertThat(updatedQuiz).isNotNull();
        assertThat(updatedQuiz.getTitle()).isEqualTo("Updated Quiz");
        assertThat(updatedQuiz.getOwnerId()).isEqualTo(1L);
    }


}
