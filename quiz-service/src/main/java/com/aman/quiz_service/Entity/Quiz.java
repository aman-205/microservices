package com.aman.quiz_service.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ElementCollection
    List<Integer> questionIds;


}
