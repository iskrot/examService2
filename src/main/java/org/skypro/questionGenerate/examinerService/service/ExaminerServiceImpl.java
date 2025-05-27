package org.skypro.questionGenerate.examinerService.service;

import org.skypro.questionGenerate.examinerService.domain.Question;
import org.skypro.questionGenerate.examinerService.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amout) throws BadRequestException {
        List<Question> questionList = new ArrayList<>();
        Question question;
        for(int i = 0; i < amout; i++){
            if (i+1 > questionService.getAll().size()){
                throw new BadRequestException();
            }
            question = questionService.getRandomQuestion();
            if (questionList.contains(question)){
                i--;
            }
            else{
                questionList.add(question);
            }
        }
        return questionList;
    }
}
