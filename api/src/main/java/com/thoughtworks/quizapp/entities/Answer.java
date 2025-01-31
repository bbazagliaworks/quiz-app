package com.thoughtworks.quizapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "answer_text")
    private String textAnswer;

    @Column(name = "selected_option_id")
    private String selectedOption;
}
