package com.aman.microQuiz.Dao;

import com.aman.microQuiz.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Questions> getQuestionByCategory(String category, int numQ);
}
