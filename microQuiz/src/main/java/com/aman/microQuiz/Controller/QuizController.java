package com.aman.microQuiz.Controller;

import com.aman.microQuiz.Entity.QuesWrapper;
import com.aman.microQuiz.Entity.Questions;
import com.aman.microQuiz.Entity.Response;
import com.aman.microQuiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuesWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuestionsById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateScore(id, responses);

    }
}
