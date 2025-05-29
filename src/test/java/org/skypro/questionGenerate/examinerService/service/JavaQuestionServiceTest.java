package org.skypro.questionGenerate.examinerService.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.questionGenerate.examinerService.domain.Question;

import java.util.ArrayList;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    Question question;
    JavaQuestionService javaQuestionService = new JavaQuestionService(new HashSet<>());

    @Test
    public void getVoidTest(){
        Assertions.assertEquals(javaQuestionService.getAll(), new ArrayList<>());
    }
    @Test
    public void getAllTest(){
        javaQuestionService.add(question);
        Assertions.assertEquals(javaQuestionService.getAll().get(0), question);
    }

    @Test
    public void addByStringTest(){
        javaQuestionService.add("1 or 2?","1");
        Assertions.assertEquals(javaQuestionService.getAll().stream().toList().get(0).getQuestion(), "1 or 2?");
    }

    @Test
    public void addByQuestTest(){
        Mockito.when(question.getQuestion()).thenReturn("1 or 2?");
        javaQuestionService.add(question);
        Assertions.assertEquals(javaQuestionService.getAll().stream().toList().get(0).getQuestion(), "1 or 2?");
    }

    @Test
    public void removeTest(){
        javaQuestionService.add(question);
        javaQuestionService.remove(question);
        Assertions.assertEquals(javaQuestionService.getAll(), new ArrayList<>());
    }
    @Test
    public void getRandomQuestionTest(){
        javaQuestionService.add(question);
        Assertions.assertEquals(javaQuestionService.getRandomQuestion(), question);
    }


}
