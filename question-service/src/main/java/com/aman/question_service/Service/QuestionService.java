package com.aman.question_service.Service;

import com.aman.question_service.Dao.QuestionDao;
import com.aman.question_service.Entity.QuesWrapper;
import com.aman.question_service.Entity.Questions;
import com.aman.question_service.Entity.Response;
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

    public ResponseEntity<List<Integer>> generateQuestionForQuiz(String category, Integer numQ) {
        List<Integer> questions= questionDao.getQuestionByCategory(category, numQ);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuesWrapper>> getQuestionByID(List<Integer> ids) {
        List<QuesWrapper> quesWrappers= new ArrayList<>();
        List<Questions> questions= new ArrayList<>();
        for(Integer id:ids){
            questions.add(questionDao.findById(id).get());
        }
        for(Questions q:questions){
            QuesWrapper quesWrapper= new QuesWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quesWrappers.add(quesWrapper);
        }
        return new ResponseEntity<>(quesWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int cnt=0;
        for(Response r:responses){
            Questions q= questionDao.findById(r.getId()).get();
            if(r.getResponse().equals(q.getCorrectAns())) cnt++;
        }
        return new ResponseEntity<>(cnt, HttpStatus.OK);
    }
}
