package com.aman.quiz_service.Feign;

import com.aman.quiz_service.Entity.QuesWrapper;
import com.aman.quiz_service.Entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQ );

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuesWrapper>> getQuestionById(@RequestBody List<Integer> id);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
