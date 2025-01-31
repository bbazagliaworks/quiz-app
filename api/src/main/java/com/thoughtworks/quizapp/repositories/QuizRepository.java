package com.thoughtworks.quizapp.repositories;

import com.thoughtworks.quizapp.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

/* JpaRepository is a Spring Data interface that provides a bunch of built-in methods, including:
* save();
* findById();
* findAll();
* deleteById();
* */