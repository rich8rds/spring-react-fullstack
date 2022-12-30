package com.richards.spring.apiresponse;

import com.richards.spring.exceptions.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse handleException(AlreadyExistsException ex) {
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .statusCode(HttpStatus.CONFLICT.value())
                .errorMessage(ex.getMessage()).build();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(IllegalArgumentException ex) {
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .errorMessage(ex.getMessage()).build();
    }
}
