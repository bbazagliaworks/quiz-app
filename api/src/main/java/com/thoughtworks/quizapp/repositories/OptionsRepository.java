package com.thoughtworks.quizapp.repositories;

import com.thoughtworks.quizapp.entities.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsRepository extends JpaRepository<Options, Long> {
}
