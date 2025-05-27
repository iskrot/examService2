package org.skypro.questionGenerate.examinerService.service;

import org.skypro.questionGenerate.examinerService.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAll();

    void add(String question, String answer);

    void add(Question question);

    void remove(Question question);

    Question getRandomQuestion();
}
