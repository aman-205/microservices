package com.aman.microQuiz.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;

    @ManyToMany
    List<Questions> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}
