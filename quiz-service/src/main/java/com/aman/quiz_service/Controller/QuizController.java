package com.aman.quiz_service.Controller;

import com.aman.quiz_service.Entity.QuesWrapper;
import com.aman.quiz_service.Entity.QuizDto;
import com.aman.quiz_service.Entity.Response;
import com.aman.quiz_service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getNumQ(), quizDto.getTitle());
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
