package com.thoughtworks.quizapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// @Entity
// @Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "quiz_id")
    private Long quizId;

    private String type;

    private String content;

    // @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
