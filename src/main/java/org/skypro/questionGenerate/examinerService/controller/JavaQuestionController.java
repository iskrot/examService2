package org.skypro.questionGenerate.examinerService.controller;

import org.skypro.questionGenerate.examinerService.domain.Question;
import org.skypro.questionGenerate.examinerService.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    public void add(@RequestParam("question") String question, @RequestParam("answer") String answer){
        javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public void remove(@RequestParam("question") String question, @RequestParam("answer") String answer){
        javaQuestionService.remove(javaQuestionService.getAll().stream().filter(i -> i.getQuestion() != question & i.getAnswer() != answer).toList().get(0));
    }

    @GetMapping("/java")
    public Collection<Question> java(){
        return (Collection<Question>) javaQuestionService.getAll();
    }

}
