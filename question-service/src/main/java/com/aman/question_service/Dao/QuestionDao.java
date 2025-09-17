package com.aman.question_service.Dao;

import com.aman.question_service.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> getQuestionByCategory(String category, int numQ);
}
