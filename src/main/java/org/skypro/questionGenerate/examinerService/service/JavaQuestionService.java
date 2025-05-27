package org.skypro.questionGenerate.examinerService.service;

import org.skypro.questionGenerate.examinerService.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questionList;
    private Random random = new Random();

    public JavaQuestionService(Set<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getAll() {
        return questionList.stream().toList();
    }

    @Override
    public void add(String question, String answer) {
        questionList.add(new Question(question, answer));
    }
    public void add(Question question) {
        questionList.add(question);
    }

    @Override
    public void remove(Question question) {
        questionList.remove(question);
    }

    public Question getRandomQuestion (){
        return questionList.stream().toList().get(random.nextInt(questionList.size()));
    }
}
