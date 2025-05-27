package org.skypro.questionGenerate.examinerService.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.questionGenerate.examinerService.domain.Question;
import org.skypro.questionGenerate.examinerService.exception.BadRequestException;

import java.util.ArrayList;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    Question question;
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    public void getQuestionsTest() throws BadRequestException {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        Mockito.when(javaQuestionService.getAll()).thenReturn(Stream.of(new Question("1", "2"), new Question("2", "4")).toList());
        Assertions.assertEquals(examinerService.getQuestions(1), Stream.of(question).toList());
    }
    @Test
    public void getVoidListTest() throws BadRequestException {
        Assertions.assertEquals(examinerService.getQuestions(0), new ArrayList<>());
    }
    @Test
    public void getTooBigListTest() throws BadRequestException {
        Exception exception = null;
        Exception exception1 = new BadRequestException();
        try {
            examinerService.getQuestions(1);
        } catch (Exception e) {
            exception = e;
        }

        Assertions.assertEquals(exception.getMessage(), exception1.getMessage());
    }

}
