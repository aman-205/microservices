package com.aman.question_service.Controller;

import com.aman.question_service.Entity.QuesWrapper;
import com.aman.question_service.Entity.Questions;
import com.aman.question_service.Entity.Response;
import com.aman.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionContoller {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return questionService.addQuestion(questions);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category,@RequestParam Integer numQ ){
        return questionService.generateQuestionForQuiz(category, numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuesWrapper>> getQuestionById(@RequestBody List<Integer> id){
        return questionService.getQuestionByID(id);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
