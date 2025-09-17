package com.aman.microQuiz.Service;

import com.aman.microQuiz.Dao.QuestionDao;
import com.aman.microQuiz.Entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestion() {
        try
        {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionByCategory(String category){
        try
        {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question){
        questionDao.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

}
