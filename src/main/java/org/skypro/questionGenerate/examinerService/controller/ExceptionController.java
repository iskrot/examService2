package org.skypro.questionGenerate.examinerService.controller;

import org.skypro.questionGenerate.examinerService.exception.BadRequestException;
import org.skypro.questionGenerate.examinerService.exception.ErrorMessege;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessege> noSuchFieldHandler(BadRequestException e){
        ErrorMessege shopError = new ErrorMessege("INVALID_REQUEST", "в списке нет столько вопросов");
        return new ResponseEntity<ErrorMessege>(shopError, HttpStatusCode.valueOf(500));
    }
}
