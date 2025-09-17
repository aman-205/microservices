package com.aman.quiz_service.Service;

import com.aman.quiz_service.Dao.QuizDao;
import com.aman.quiz_service.Entity.QuesWrapper;
import com.aman.quiz_service.Entity.Quiz;
import com.aman.quiz_service.Entity.Response;
import com.aman.quiz_service.Feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Integer> questions= quizInterface.generateQuestionForQuiz(category, numQ).getBody();
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

    public ResponseEntity<List<QuesWrapper>> getQuestionsById(Integer id) {
        Quiz quiz= quizDao.findById(id).get();
        List<Integer> questionIds= quiz.getQuestionIds();

        ResponseEntity<List<QuesWrapper>>question=quizInterface.getQuestionById(questionIds);
        return  question;
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        ResponseEntity<Integer>score= quizInterface.getScore(responses);
        return score;
    }
}
