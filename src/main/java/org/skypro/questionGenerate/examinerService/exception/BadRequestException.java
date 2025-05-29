package org.skypro.questionGenerate.examinerService.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){
        super("BAD_REQUEST");
    }
}
