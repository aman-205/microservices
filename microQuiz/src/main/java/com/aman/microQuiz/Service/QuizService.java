package com.aman.microQuiz.Service;

import com.aman.microQuiz.Dao.QuestionDao;
import com.aman.microQuiz.Dao.QuizDao;
import com.aman.microQuiz.Entity.QuesWrapper;
import com.aman.microQuiz.Entity.Questions;
import com.aman.microQuiz.Entity.Quiz;
import com.aman.microQuiz.Entity.Response;
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
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        Quiz quiz = new Quiz();
        List<Questions> questions= questionDao.getQuestionByCategory(category, numQ);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

    public ResponseEntity<List<QuesWrapper>> getQuestionsById(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Questions> qFromDB= quiz.get().getQuestions();
        List<QuesWrapper> qForUser= new ArrayList<>();
        for(Questions q:qFromDB){
            QuesWrapper quesWrapper= new QuesWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            qForUser.add(quesWrapper);
        }
        return  new ResponseEntity<>(qForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        Quiz quiz= quizDao.findById(id).get();
        List<Questions> questions= quiz.getQuestions();
        int i=0,cnt=0;
        for(Response r:responses){
            if(r.getResponse().equals(questions.get(i).getCorrectAns())){
                cnt++;
            }
            i++;
        }
        return new ResponseEntity<>(cnt,HttpStatus.OK);
    }
}
