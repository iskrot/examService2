package org.skypro.questionGenerate.examinerService.controller;


import org.skypro.questionGenerate.examinerService.domain.Question;
import org.skypro.questionGenerate.examinerService.exception.BadRequestException;
import org.skypro.questionGenerate.examinerService.service.ExaminerServiceImpl;
import org.skypro.questionGenerate.examinerService.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class examController {
    private final JavaQuestionService javaQuestionService;
    ExaminerServiceImpl examinerService;;

    public examController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
        examinerService = new ExaminerServiceImpl(javaQuestionService);
    }

    @GetMapping("/exam/get")
    Collection<Question> randomQuestions(@RequestParam("amout") int amout) throws BadRequestException {
        return examinerService.getQuestions(amout);
    }

}
