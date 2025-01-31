package com.thoughtworks.quizapp.repositories;

import com.thoughtworks.quizapp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
