package com.aniket.jobtrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(JobNotFoundException ex){
         ErrorResponse er = new ErrorResponse();
         er.setMessage(ex.getMessage());
         er.setStatus(HttpStatus.NOT_FOUND.value());
         er.setTimestamp(LocalDateTime.now());

         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex){
    ErrorResponse error = new ErrorResponse();

    StringJoiner message = new StringJoiner(", ");

    for(var er: ex.getBindingResult().getFieldErrors()){
        message.add(er.getField() + ": " + er.getDefaultMessage());
    }

    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(message.toString());
    error.setTimestamp(LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleApplicationNotFound(ApplicationNotFoundException ex){
        ErrorResponse er = new ErrorResponse();
        er.setMessage(ex.getMessage());
        er.setStatus(HttpStatus.NOT_FOUND.value());
        er.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
