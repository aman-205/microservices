package com.aman.microQuiz.Dao;

import com.aman.microQuiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
