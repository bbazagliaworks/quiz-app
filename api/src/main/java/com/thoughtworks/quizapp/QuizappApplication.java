package com.thoughtworks.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class QuizappApplication {

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World";
  }

  @RequestMapping("/foo")
  public String foo() {
    return "bar";
  }

  public static void main(String[] args) {
    SpringApplication.run(QuizappApplication.class, args);
  }

}