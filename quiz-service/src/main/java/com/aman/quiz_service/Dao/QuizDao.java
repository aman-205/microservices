package com.aman.quiz_service.Dao;

import com.aman.quiz_service.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
