package org.skypro.questionGenerate.examinerService.service;

import org.skypro.questionGenerate.examinerService.domain.Question;
import org.skypro.questionGenerate.examinerService.exception.BadRequestException;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amout) throws BadRequestException;
}
