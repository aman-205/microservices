package com.aman.microQuiz.Controller;

import com.aman.microQuiz.Entity.Questions;
import com.aman.microQuiz.Service.QuestionService;
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


}
